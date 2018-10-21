package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "dbtest")
public class User {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;

    /**
     * Имя пользователя
     */
    @Column(name = "user_name")
    private String name;

    /**
     * Фамилия пользователя
     */
    @Column(name = "user_second_name")
    private String secondName;

    /**
     * Счета пользователя
     */
    @OneToMany(mappedBy =  "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<BankAccount> bankAccounts;

}
