package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import javax.persistence.Table;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "bank_account", schema = "dbtest")
public class BankAccount {

    /**
     * Идентификатор счета
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}
