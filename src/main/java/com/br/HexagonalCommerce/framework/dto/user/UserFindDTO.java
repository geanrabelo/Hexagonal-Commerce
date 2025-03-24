package com.br.HexagonalCommerce.framework.dto.user;

import com.br.HexagonalCommerce.core.entities.UserEntity;
import com.br.HexagonalCommerce.core.enums.Roles;

public record UserFindDTO(Long id, String login, String password, Roles roles) {
    public UserFindDTO(Long id, UserEntity userEntity){
        this(id, userEntity.getLogin(), userEntity.getPassword(), userEntity.getRoles());
    }

}
