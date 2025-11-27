package com.dev_renan01.data.DTO.v2;

import com.sun.tools.rngom.digested.DValuePattern;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class PessoaDTOV2 implements Serializable {

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

    @Column(nullable = false, length = 20)
    private Date dataNascimento;

    @Column(nullable = false, length = 10)
    private String genero;

    public PessoaDTOV2(){}

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PessoaDTOV2 that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getSobrenome(), that.getSobrenome()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getDataNascimento(), that.getDataNascimento()) && Objects.equals(getGenero(), that.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getDataNascimento(), getGenero());
    }
}
