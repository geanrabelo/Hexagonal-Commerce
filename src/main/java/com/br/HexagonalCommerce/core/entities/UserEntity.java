package com.br.HexagonalCommerce.core.entities;

import com.br.HexagonalCommerce.core.enums.Roles;

public class UserEntity {

    private Long id;
    private String login;
    private String password;
    private Roles roles;

    public UserEntity(String password, String login, Roles roles) {
        this.password = password;
        this.login = login;
        this.roles = roles;
    }

    public UserEntity(Long id, String login, String password, Roles roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
