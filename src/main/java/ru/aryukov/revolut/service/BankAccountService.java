package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.BankAccPost;
import ru.aryukov.revolut.dto.BankAccPut;
import ru.aryukov.revolut.dto.BankAccountDto;
import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.TransferPost;

import javax.annotation.Nullable;
import java.util.Optional;

public interface BankAccountService {

    ResponseEntity getBankAccount(long bankAccId);

    ResponseEntity createAccount(final BankAccPost prarms);

    ResponseEntity transfer(TransferPost params);

    Optional<BankAccountDto> updateBankAccount(@Nullable long bankAccId, BankAccPut params);

    boolean getMoney(Long bankAccountId, double summ);

    boolean putMoney(Long bankAccountId, double summ);
}
