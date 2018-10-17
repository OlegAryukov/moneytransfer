package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_second_name")
    private String secondName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy =  "userId")

    List<BankAccount> bankAccounts;

}
