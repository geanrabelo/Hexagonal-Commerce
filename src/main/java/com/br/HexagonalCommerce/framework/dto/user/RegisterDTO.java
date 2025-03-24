package com.br.HexagonalCommerce.framework.dto.user;

import com.br.HexagonalCommerce.core.enums.Roles;

public record RegisterDTO(String login, String password, Roles roles) {
}
