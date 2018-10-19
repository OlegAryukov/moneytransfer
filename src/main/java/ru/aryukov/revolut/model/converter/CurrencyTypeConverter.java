package ru.aryukov.revolut.model.converter;

import ru.aryukov.revolut.model.CurrencyType;

import javax.persistence.AttributeConverter;

public class CurrencyTypeConverter implements AttributeConverter<CurrencyType, String>{
    @Override
    public String convertToDatabaseColumn(CurrencyType currencyType) {
        return currencyType.getKeyName();
    }

    @Override
    public CurrencyType convertToEntityAttribute(String currencyTypeKeyName) {
        return CurrencyType.valueOf(currencyTypeKeyName);
    }
}
