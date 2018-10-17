package ru.aryukov.revolut.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "operation_history")
public class OperationHistory {

    private String UUID;

    private OperationType operationType;

    private Long userFrom;

    private Long bankAccountFrom;

    private Long userTo;


    private Long bankAccountTo;

    @CreationTimestamp
    @Column(name = "operation_date_utc")
    private Instant operationTime;


}
