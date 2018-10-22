package ru.aryukov.revolut.utils;


import com.google.inject.Inject;
import ru.aryukov.revolut.dao.UserDao;
import ru.aryukov.revolut.dto.BankAccPost;
import ru.aryukov.revolut.dto.BankAccPut;
import ru.aryukov.revolut.dto.UserPost;
import ru.aryukov.revolut.model.BankAccount;
import ru.aryukov.revolut.model.CurrencyType;
import ru.aryukov.revolut.model.User;

import java.util.Optional;

public class EntityUtils {

    @Inject
    private UserDao userDao;

    public EntityUtils() {
    }

    public User createUser(UserPost user){
        User entity = new User();
        entity.setName(user.getName());
        entity.setSecondName(user.getSecondName());
        return  entity;
    }

    public User mergePut(User entity, UserPost params){
        entity.setName(params.getName());
        entity.setSecondName(params.getSecondName());
        return entity;
    }

    public BankAccount mergeBankAcc(BankAccount entity, BankAccPut params){
        entity.setAmount(params.getAmount());
        return entity;
    }

    private void setUserIfExist(Optional<User> userEntity, BankAccount accountEntity) {
        if(userEntity.isPresent()){
            accountEntity.setUser(userEntity.get());
        } else {
            //throw new ValidationException("Пользователь для которого создается счет не найден");
        }
    }
}
