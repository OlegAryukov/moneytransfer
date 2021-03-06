package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import ru.aryukov.revolut.dao.BankAccountDao;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.dao.impl.BankAccountDaoImpl;
import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.post.BankAccPost;
import ru.aryukov.revolut.dto.post.TransactionPost;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.TransferPostWithExchange;
import ru.aryukov.revolut.dto.response.NotFoundResponse;
import ru.aryukov.revolut.dto.response.TransferResultResponse;
import ru.aryukov.revolut.model.BankAccount;
import ru.aryukov.revolut.model.OperationType;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.service.TransactionsLog;
import ru.aryukov.revolut.utils.MapperUtils;

import java.math.BigDecimal;
import java.time.Instant;

public class BankAccountServiceImp implements BankAccountService {

    private static Logger logger = Logger.getLogger(BankAccountServiceImp.class);

    @Inject
    private BankAccountDao bankAccountDao;
    @Inject
    private UserDao userDao;
    @Inject
    private TransactionsLog transactionLog;

    public ResponseEntity getBankAccount(long bankAccId) {
        logger.debug("Looking for Bank Account with id:" + bankAccId);
        BankAccount entity = bankAccountDao.findByID(BankAccount.class, bankAccId);
        if (entity != null) {
            return MapperUtils.mapBankAcc(entity);
        } else {
            return NotFoundResponse.builder()
                    .message("Not found bank account with id:" + bankAccId)
                    .build();
        }
    }

    @Override
    public ResponseEntity createAccount(BankAccPost params) {
        logger.debug("Create bank account for user with id:" + params.getUserId());
        User user = userDao.findByID(User.class, params.getUserId());
        if (user != null) {
            BankAccount bankAccount = new BankAccount(params, user);
            return MapperUtils.mapBankAcc(bankAccountDao.create(bankAccount));
        } else {
            return NotFoundResponse.builder()
                    .message("No user with id:" + params.getUserId() + " so, can not create Bank Account")
                    .build();
        }
    }

    public ResponseEntity transfer(TransferPost params) {
        logger.debug("Try handle transfer between bank account id:" + params.getBankAccIdSource()
                + " to bank account with id:" + params.getBankAccIdSource() + " transfer sum is " + params.getSum());

        BankAccount accSource = bankAccountDao.findByID(BankAccount.class, params.getBankAccIdSource());
        BankAccount accDest = bankAccountDao.findByID(BankAccount.class, params.getBankAccIdDest());
        if (accDest != null && accSource != null) {
            if (checkPossable(accSource.getAmount(), params.getSum())) {
                BigDecimal newSourceAmount = accSource.getAmount().subtract(params.getSum());
                BigDecimal newDestAmount = accDest.getAmount().add(params.getSum());
                accSource.setAmount(newSourceAmount);
                accDest.setAmount(newDestAmount);
                bankAccountDao.transfer(accSource, accDest);

                TransactionPost trParams = TransactionPost.builder()
                        .bankAccountSource(params.getBankAccIdSource())
                        .userFrom(accSource.getUser().getId())
                        .currSourceType(accSource.getCurrency())
                        .sum(params.getSum())
                        .bankAccountDest(params.getBankAccIdDest())
                        .userTo(accDest.getUser().getId())
                        .currDestType(accDest.getCurrency())
                        .operationType(OperationType.TRANSFER)
                        .operationTime(Instant.now())
                        .build();

                transactionLog.logTransaction(trParams);

                return TransferResultResponse.builder()
                        .message("Transfer SUCCESS")
                        .build();
            } else {
                return TransferResultResponse.builder()
                        .message("Transfer NOT SUCCESS on account " + params.getBankAccIdSource() + " not enough money")
                        .build();
            }
        } else {
            return TransferResultResponse.builder()
                    .message("Not found one of account")
                    .build();
        }
    }

    public ResponseEntity transferWithExchange(TransferPostWithExchange params) {
        logger.debug("Try handle transfer with exchange between bank account id:" + params.getBankAccIdSource()
                + " to bank account with id:" + params.getBankAccIdSource() + " transfer sum is " + params.getSum());

        BankAccount accSource = bankAccountDao.findByID(BankAccount.class, params.getBankAccIdSource());
        BankAccount accDest = bankAccountDao.findByID(BankAccount.class, params.getBankAccIdDest());
        BigDecimal sumAfterConvert = params.getSum().multiply(params.getExchangeCourse());
        if (accDest != null && accSource != null) {
            if (checkPossable(accSource.getAmount(), sumAfterConvert)) {
                BigDecimal newSourceAmount = accSource.getAmount().subtract(sumAfterConvert);
                BigDecimal newDestAmount = accDest.getAmount().add(sumAfterConvert);
                accSource.setAmount(newSourceAmount);
                accDest.setAmount(newDestAmount);
                bankAccountDao.transfer(accSource, accDest);

                TransactionPost trParams = TransactionPost.builder()
                        .bankAccountSource(params.getBankAccIdSource())
                        .userFrom(accSource.getUser().getId())
                        .currSourceType(accSource.getCurrency())
                        .sum(sumAfterConvert)
                        .crossCourse(params.getExchangeCourse())
                        .bankAccountDest(params.getBankAccIdDest())
                        .userTo(accDest.getUser().getId())
                        .currDestType(accDest.getCurrency())
                        .operationType(OperationType.TRANSFER_WITH_EXCHANGE)
                        .operationTime(Instant.now())
                        .build();

                transactionLog.logTransactionWithExchenge(trParams);

                return TransferResultResponse.builder()
                        .message("Transfer SUCCESS")
                        .build();
            } else {
                return TransferResultResponse.builder()
                        .message("Transfer NOT SUCCESS on account " + params.getBankAccIdSource() + " not enough money")
                        .build();
            }
        } else {
            return TransferResultResponse.builder()
                    .message("Not found one of account")
                    .build();
        }
    }

    private boolean checkPossable(BigDecimal accSum, BigDecimal existSum) {
        return accSum.compareTo(existSum) >= 0;
    }
}
