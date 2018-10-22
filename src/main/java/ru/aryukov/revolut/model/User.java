package ru.aryukov.revolut.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "dbtest")
public class User {

    @Version
    @Column(name = "version")
    private Long version;

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequence-generator")
    @SequenceGenerator(name = "sequence-generator", sequenceName = "USER_ID_SEQ", allocationSize = 1)
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
    List<BankAccount> bankAccounts = new ArrayList<>();

}
