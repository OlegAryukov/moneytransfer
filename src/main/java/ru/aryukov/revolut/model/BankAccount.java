package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.aryukov.revolut.dto.post.BankAccPost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "bank_account", schema = "dbtest")
public class BankAccount {

    @Version
    @Column(name = "version")
    private Long version;

    /**
     * Идентификатор счета
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "BANK_ACC_ID_SEQ", allocationSize = 1)
    @Column(name = "bank_account_id")
    private Long id;

    /**
     * Баланс счета
     */
    @Column(name = "amount", scale = 2)
    private BigDecimal amount;

    /**
     * Тип валюты счета
     */
    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    /**
     * Владелец счета
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id")
    private User user;

    public BankAccount(BankAccPost params, User user) {
        this.amount = params.getAmount();
        this.currency = CurrencyType.valueOf(params.getCurrType());
        this.user = user;
    }
}
