package ru.aryukov.revolut.service;

import ru.aryukov.revolut.dto.ResponseEntity;
import ru.aryukov.revolut.dto.post.BankAccPost;
import ru.aryukov.revolut.dto.post.TransferPost;
import ru.aryukov.revolut.dto.post.TransferPostWithExchange;

public interface BankAccountService {

    ResponseEntity getBankAccount(long bankAccId);

    ResponseEntity createAccount(final BankAccPost prarms);

    ResponseEntity transfer(TransferPost params);

    ResponseEntity transferWithExchange(TransferPostWithExchange params);
}
