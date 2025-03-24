package com.br.HexagonalCommerce.framework.dto.order;

import com.br.HexagonalCommerce.framework.domain.User;

import java.util.UUID;

public record OrderFindDTO(UUID uuid, User user, float price) {
}
