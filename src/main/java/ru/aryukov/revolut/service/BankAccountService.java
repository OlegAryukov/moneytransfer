package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.BankAccPost;
import ru.aryukov.revolut.dto.BankAccPut;
import ru.aryukov.revolut.dto.BankAccountDto;

import javax.annotation.Nullable;
import java.util.Optional;

public interface BankAccountService {

    Optional<BankAccountDto> getBankAccoun(long bankAccId);

    BankAccountDto createAccount(final BankAccPost prarms, @Nullable long userId);

    Optional<BankAccountDto> updateBankAccount(@Nullable long bankAccId, BankAccPut params);

    boolean getMoney(Long bankAccountId, double summ);

    boolean putMoney(Long bankAccountId, double summ);
}
