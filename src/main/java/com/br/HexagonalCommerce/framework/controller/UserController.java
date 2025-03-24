package com.br.HexagonalCommerce.framework.controller;

import com.br.HexagonalCommerce.core.exceptions.UserNotFound;
import com.br.HexagonalCommerce.core.usecases.UserUseCases;
import com.br.HexagonalCommerce.framework.dto.user.UserCreatedDTO;
import com.br.HexagonalCommerce.framework.dto.user.UserResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commerce/user")
public class UserController {

    @Autowired
    private UserUseCases userUseCases;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid UserResponseDTO userResponseDTO){
        userUseCases.create(userResponseDTO.login(), userResponseDTO.password(), userResponseDTO.roles());
        return ResponseEntity.ok(new UserCreatedDTO(userResponseDTO.login(), userResponseDTO.password(), userResponseDTO.roles()));
    }

    @GetMapping
    public ResponseEntity<?> findById(@RequestParam(value = "id") Long id) throws UserNotFound {
        return ResponseEntity.ok(userUseCases.findById(id));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> deleteById(@RequestParam(value = "id") Long id) throws UserNotFound {
        userUseCases.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
