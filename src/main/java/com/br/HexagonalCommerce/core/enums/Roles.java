package com.br.HexagonalCommerce.core.enums;

public enum Roles {
    ADMIN("ADMIN"),
    USER("USER");


    private String role;

    Roles(String role){
        this.role = role;
    }
    public String getRole(){
        return this.role;
    }
}
