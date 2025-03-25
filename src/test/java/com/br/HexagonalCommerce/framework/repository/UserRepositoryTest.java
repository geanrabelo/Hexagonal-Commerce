package com.br.HexagonalCommerce.framework.repository;

import com.br.HexagonalCommerce.core.enums.Roles;
import com.br.HexagonalCommerce.framework.domain.User;
import com.br.HexagonalCommerce.framework.dto.user.UserCreatedDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Procurando pelo nome no banco de dados!")
    void findByLogin() {
        UserCreatedDTO userCreatedDTO = new UserCreatedDTO("admin", "admin", Roles.ADMIN);
        var user = create(userCreatedDTO);
        var userFound = userRepository.findByLogin(user.getLogin());

        assertThat(userFound.isPresent()).isTrue();

    }

    private User create(UserCreatedDTO userCreatedDTO){
        var user = new User(userCreatedDTO.login(), userCreatedDTO.password(), userCreatedDTO.roles());
        entityManager.persist(user);
        return user;
    }
}