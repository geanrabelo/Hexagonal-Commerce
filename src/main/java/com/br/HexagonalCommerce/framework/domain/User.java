package com.br.HexagonalCommerce.framework.domain;


import com.br.HexagonalCommerce.core.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_user")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class User {

    public User(String login, String password, Roles roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public User(Long id, String login, String password, Roles roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

}
