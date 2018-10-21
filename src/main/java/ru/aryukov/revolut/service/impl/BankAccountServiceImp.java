package ru.aryukov.revolut.service.impl;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import lombok.extern.slf4j.Slf4j;
import ru.aryukov.revolut.dao.BankAccountDao;
import ru.aryukov.revolut.dto.BankAccPost;
import ru.aryukov.revolut.dto.BankAccPut;
import ru.aryukov.revolut.dto.BankAccountDto;
import ru.aryukov.revolut.model.BankAccount;
import ru.aryukov.revolut.service.BankAccountService;
import ru.aryukov.revolut.utils.MapperUtils;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
public class BankAccountServiceImp implements BankAccountService {

    @Inject
    private BankAccountDao bankAccountDao;

    @Override
    public Optional<BankAccountDto> getBankAccoun(long bankAccId) {
        log.debug("Looking for Bank Account with id:{}", bankAccId);

        return Optional.of(bankAccountDao.findByID(BankAccount.class, bankAccId))
                .map(MapperUtils::mapBankAcc);
    }

    @Override
    public BankAccountDto createAccount(BankAccPost prarms, @Nullable long userId) {
        return null;
    }

    @Override
    public Optional<BankAccountDto> updateBankAccount(long bankAccId, BankAccPut params) {
        return null;
    }

    @Transactional
    @Override
    public boolean getMoney(Long bankAccountId, double sum) {
        boolean operationFlag = true;
//        BankAccount account = bankAccountDao.findByID(BankAccount.class, bankAccountId);
//        BigDecimal accSum = account.getAmount();
//        BigDecimal sumForOpe = new BigDecimal(sum);
//        if (checkPossable(accSum, sumForOpe)) {
//            accSum.subtract(sumForOpe);
//        } else {
//            operationFlag = false;
//        }
//        account.setAmount(accSum);
//        bankAccountDao.update(account);
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
