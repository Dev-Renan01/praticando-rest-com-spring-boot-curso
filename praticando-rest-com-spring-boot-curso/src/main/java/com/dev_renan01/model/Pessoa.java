package com.dev_renan01.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String genero;

    public Pessoa(){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getSobrenome(), pessoa.getSobrenome()) && Objects.equals(getEndereco(), pessoa.getEndereco()) && Objects.equals(getGenero(), pessoa.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getGenero());
    }
}
