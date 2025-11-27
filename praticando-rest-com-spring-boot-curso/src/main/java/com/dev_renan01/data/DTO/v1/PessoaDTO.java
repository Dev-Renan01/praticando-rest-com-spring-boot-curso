package com.dev_renan01.data.DTO.v1;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 80)
    private String sobrenome;

    @Column(nullable = false, length = 80)
    private String endereco;

    @Column(nullable = false, length = 10)
    private String genero;

    public PessoaDTO(){}

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
        if (!(o instanceof PessoaDTO pessoa)) return false;
        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getSobrenome(), pessoa.getSobrenome()) && Objects.equals(getEndereco(), pessoa.getEndereco()) && Objects.equals(getGenero(), pessoa.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getGenero());
    }
}
