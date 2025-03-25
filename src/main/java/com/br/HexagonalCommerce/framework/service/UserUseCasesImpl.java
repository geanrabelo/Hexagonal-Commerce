package com.br.HexagonalCommerce.framework.service;

import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.enums.Roles;
import com.br.HexagonalCommerce.core.exceptions.UserNotFound;
import com.br.HexagonalCommerce.core.usecases.UserUseCases;
import com.br.HexagonalCommerce.framework.domain.User;
import com.br.HexagonalCommerce.framework.mapper.UserMapper;
import com.br.HexagonalCommerce.framework.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserUseCasesImpl implements UserUseCases {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserUseCasesImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public void create(String name, String password, Roles roles) {
        userRepository.save(new User(name, password, roles));
    }

    @Override
    public void deleteById(Long id) throws UserNotFound {
        if(existsById(id)){
            userRepository.deleteById(id);
        }
    }


    @Override
    public boolean existsById(Long id) throws UserNotFound {
        if(!userRepository.existsById(id)){
            throw new UserNotFound("User searched by id not found");
        }
        return true;
    }

    @Override
    public UserEntity findById(Long id) throws UserNotFound {
        if(existsById(id)){
            var userEntity = userRepository.getReferenceById(id);
            return userMapper.toUserEntityWithId(userEntity);
        }else{
            return null;
        }
    }
}
