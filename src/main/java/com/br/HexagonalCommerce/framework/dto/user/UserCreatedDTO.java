package com.br.HexagonalCommerce.framework.dto.user;

import com.br.HexagonalCommerce.core.enums.Roles;
import com.br.HexagonalCommerce.framework.domain.User;

public record UserCreatedDTO(String login, String password, Roles roles) {

    public UserCreatedDTO(User user){
        this(user.getLogin(), user.getPassword(), user.getRoles());
    }
}
