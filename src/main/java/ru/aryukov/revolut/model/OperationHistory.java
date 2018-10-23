package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import ru.aryukov.revolut.dto.post.TransactionPost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "operation_history", schema = "dbtest")
public class OperationHistory {

    /**
     * Идентификатор транзакции
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "operation_history_id", updatable = false, nullable = false)
    private UUID id;

    /**
     * Тип операции
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    private OperationType operationType;

    /**
     * Пользователь отправитель
     */
    @Column(name = "user_id_from")
    private Long userFrom;

    /**
     * Тип валюты счета списания
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "curr_type_from")
    private CurrencyType currTypeFrom;

    /**
     * Счет списания
     */
    @Column(name = "bank_account_id_from")
    private Long bankAccountFrom;

    /**
     * Сумма трансфера в валюте отправителя
     */
    @Column(name = "summ")
    private BigDecimal summ;

    @Column(name = "cross_course")
    private BigDecimal crossCourse;

    /**
     * Пользователь получатель
     */
    @Column(name = "user_id_to")
    private Long userTo;

    /**
     * Тип валюты счета получателя
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "curr_type_to")
    private CurrencyType currTypeTo;

    /**
     * Счет поступления
     */
    @Column(name = "bank_account_id_to")
    private Long bankAccountTo;

    /**
     * Время записи транзакции
     */
    @CreationTimestamp
    @Column(name = "operation_date_utc", nullable = false)
    private Instant operationTime;

    public OperationHistory(TransactionPost post) {
        this.operationType = post.getOperationType();
        this.userFrom = post.getUserFrom();
        this.currTypeFrom = post.getCurrSourceType();
        this.bankAccountFrom = post.getBankAccountSource();
        this.summ = post.getSum();
        this.crossCourse = post.getCrossCourse();
        this.userTo = post.getUserTo();
        this.currTypeTo = post.getCurrDestType();
        this.bankAccountTo = post.getBankAccountDest();
        this.operationTime = post.getOperationTime();
    }
}
