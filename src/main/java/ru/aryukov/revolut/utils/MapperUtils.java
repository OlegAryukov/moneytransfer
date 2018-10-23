package ru.aryukov.revolut.utils;

import ru.aryukov.revolut.dto.BankAccountDto;
import ru.aryukov.revolut.dto.OperationDto;
import ru.aryukov.revolut.dto.UserDto;
import ru.aryukov.revolut.model.BankAccount;
import ru.aryukov.revolut.model.OperationHistory;
import ru.aryukov.revolut.model.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapperUtils {

    public MapperUtils() {
    }

    public static UserDto mapUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .secondName(user.getSecondName())
                .bankAccounts(Optional.ofNullable(user.getBankAccounts()).orElse(null).stream()
                        .map(bankAccount -> BankAccountDto.builder()
                                .amount(bankAccount.getAmount())
                                .currencyType(bankAccount.getCurrency().getWorldCode())
                                .build()).collect(Collectors.toList()))
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

    public static OperationDto mapOperationDto(OperationHistory oh) {
        return OperationDto.builder()
                .id(oh.getId())
                .userFrom(oh.getUserFrom())
                .bankAccountFrom(oh.getBankAccountFrom())
                .currTypeFrom(oh.getCurrTypeFrom().getWorldCode())
                .sum(oh.getSumm().toString())
                .userTo(oh.getUserTo())
                .bankAccountTo(oh.getBankAccountTo())
                .currTypeTo(oh.getCurrTypeTo().getWorldCode())
                .operationType(oh.getOperationType().operationName)
                .operationTime(LocalDateTime.ofInstant(oh.getOperationTime(), ZoneOffset.UTC))
                .build();
    }

}
