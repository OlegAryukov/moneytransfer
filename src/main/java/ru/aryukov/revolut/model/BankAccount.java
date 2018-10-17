package ru.aryukov.revolut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "amount", scale = 2)
    private BigDecimal amount;

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;


    private Long userId;

}
