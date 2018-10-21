package ru.aryukov.revolut.utils;

import ru.aryukov.revolut.dto.BankAccountDto;
import ru.aryukov.revolut.dto.UserDto;
import ru.aryukov.revolut.model.BankAccount;
import ru.aryukov.revolut.model.User;

public class MapperUtils {

    public MapperUtils() {
    }

    public static UserDto mapUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .secondName(user.getSecondName())
                .bankAccounts(user.getBankAccounts())
                .build();
    }

    public static BankAccountDto mapBankAcc(BankAccount ba) {
        return BankAccountDto.builder()
                .id(ba.getId())
                .amount(ba.getAmount())
                .currencyType(ba.getCurrency().getKeyName())
                .user(mapUser(ba.getUser()))
                .build();
    }
}
