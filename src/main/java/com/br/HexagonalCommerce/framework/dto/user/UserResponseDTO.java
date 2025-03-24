package com.br.HexagonalCommerce.framework.dto.user;

import com.br.HexagonalCommerce.core.enums.Roles;

public record UserResponseDTO(String login, String password, Roles roles) {
}
