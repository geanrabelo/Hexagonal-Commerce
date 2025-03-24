package com.br.HexagonalCommerce.framework.Exceptions;

import com.br.HexagonalCommerce.core.exceptions.OrderNotFound;
import com.br.HexagonalCommerce.core.exceptions.ProductNotFound;
import com.br.HexagonalCommerce.core.exceptions.UserNotFound;
import com.br.HexagonalCommerce.framework.Exceptions.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse userNotFoundHandler(UserNotFound userNotFound){
        return ErrorResponse.notFound(userNotFound.getMessage());
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse productNotFoundHandler(ProductNotFound productNotFound){
        return ErrorResponse.notFound(productNotFound.getMessage());
    }

    @ExceptionHandler(OrderNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse orderNotFoundHandler(OrderNotFound orderNotFound){
        return ErrorResponse.notFound(orderNotFound.getMessage());
    }

}
