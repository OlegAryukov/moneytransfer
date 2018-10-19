package ru.aryukov.revolut.model.converter;

import ru.aryukov.revolut.model.OperationType;

import javax.persistence.AttributeConverter;

public class OperationTypeConverter implements AttributeConverter<OperationType, String> {

    @Override
    public String convertToDatabaseColumn(OperationType operationType) {
        return null;
    }

    @Override
    public OperationType convertToEntityAttribute(String operationTypeKeyName) {
        return null;
    }
}
