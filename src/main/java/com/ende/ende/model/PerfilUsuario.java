package com.ende.ende.model;

public enum PerfilUsuario {

    ADMINISTRADOR("Administrador"),
    ATENDENTE("Atendente");

    private String descricao;

    private PerfilUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
