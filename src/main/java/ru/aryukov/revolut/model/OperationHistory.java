package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "operation_history", schema = "dbtest")
public class OperationHistory {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "operation_history_id", updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "user_id_from")
    private Long userFrom;

    @Column(name = "bank_account_id_from")
    private Long bankAccountFrom;

    @Column(name = "user_id_to")
    private Long userTo;

    @Column(name = "bank_account_id_to")
    private Long bankAccountTo;

    @CreationTimestamp
    @Column(name = "operation_date_utc")
    private Instant operationTime;

}
