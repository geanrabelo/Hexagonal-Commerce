package com.br.HexagonalCommerce.framework.mapper;


import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.framework.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntityWithId(User user){
        return new UserEntity(user.getId(), user.getLogin(), user.getPassword(), user.getRoles());
    }

    public UserEntity toUserEntity(User user){
        return new UserEntity(user.getLogin(), user.getPassword(), user.getRoles());
    }

    public User toUser(UserEntity userEntity){
        return new User(userEntity.getLogin(), userEntity.getPassword(), userEntity.getRoles());
    }

    public User toUserWithId(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getLogin(), userEntity.getPassword(), userEntity.getRoles());
    }
}
