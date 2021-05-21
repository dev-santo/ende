package com.ende.ende.model;

public enum Genero {

    MASCULINO("Masculino"),
    FEMENINO("Femenino");

    private String descricao;

    private Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
