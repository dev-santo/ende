package com.ende.ende.model;

public enum PerfilUsuario {

    ADMINISTRADOR("Administrador"),
    CALLCENTER("Call Center");

    private String descricao;

    private PerfilUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
