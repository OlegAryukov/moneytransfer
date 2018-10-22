package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import lombok.extern.slf4j.Slf4j;
import ru.aryukov.revolut.dao.BankAccountDao;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.dto.BankAccPost;
import ru.aryukov.revolut.dto.BankAccPut;
import ru.aryukov.revolut.dto.BankAccountDto;
import ru.aryukov.revolut.dto.NotFoundResponse;
import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.TransferPost;
import ru.aryukov.revolut.dto.TransferResultResponse;
import ru.aryukov.revolut.model.BankAccount;
import ru.aryukov.revolut.model.User;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.utils.EntityUtils;
import ru.aryukov.revolut.utils.MapperUtils;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
public class BankAccountServiceImp implements BankAccountService {

    @Inject
    private BankAccountDao bankAccountDao;
    @Inject
    private UserDao userDao;
    @Inject
    private EntityUtils entityUtils;

    public ResponseEntity getBankAccount(long bankAccId) {
        log.debug("Looking for Bank Account with id:{}", bankAccId);
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
        log.debug("Create bank account for user with id:" + params.getUserId());
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
        log.debug("Try handle transfer between bank account id:" + params.getBankAccIdSource()
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
                    .message("Not found on of accounts")
                    .build();
        }
    }

    @Override
    public Optional<BankAccountDto> updateBankAccount(long bankAccId, BankAccPut params) {
        return null;
    }

    @Transactional
    @Override
    public boolean getMoney(Long bankAccountId, double sum) {
        boolean operationFlag = true;
        return operationFlag;
    }

    @Transactional
    @Override
    public boolean putMoney(Long bankAccountId, double sum) {
        return false;
    }

    private boolean checkPossable(BigDecimal accSum, BigDecimal existSum) {
        return accSum.compareTo(existSum) >= 0 ? true : false;
    }
}
