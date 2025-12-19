package com.dev_renan01.data.DTO;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.dev_renan01.serializer.GeneroSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
//@JsonPropertyOrder({"id", "nome", "sobrenome", "endereco", "genero" })    // Custumizar a ordem de exibição do Json
public class PessoaDTO extends RepresentationModel<PessoaDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false, length = 80)
    private String nome;

   // @JsonProperty("sobrenome") //Define queal será o nome exibido
    @Column(nullable = false, length = 80)
    private String sobrenome;

    @Column(nullable = false, length = 80)
    private String endereco;

    @Column(nullable = false, length = 80)
    @JsonInclude(JsonInclude.Include.NON_EMPTY) // O campo so será renderizado quando não for null
    private String numeroTelefone;

    @JsonFormat(pattern = "dd/MM/yyyy") // formatar a data para um padrão brasileiro
    private Date dataNascimento;

   // @JsonIgnore
   // Define que o GeneroSerializer será usado para setar o valor final no JSON durante a serialização.
    @JsonSerialize(using = GeneroSerializer.class)
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PessoaDTO pessoaDTO)) return false;
        return Objects.equals(getId(), pessoaDTO.getId()) && Objects.equals(getNome(), pessoaDTO.getNome()) && Objects.equals(getSobrenome(), pessoaDTO.getSobrenome()) && Objects.equals(getEndereco(), pessoaDTO.getEndereco()) && Objects.equals(getNumeroTelefone(), pessoaDTO.getNumeroTelefone()) && Objects.equals(getDataNascimento(), pessoaDTO.getDataNascimento()) && Objects.equals(getGenero(), pessoaDTO.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getSobrenome(), getEndereco(), getNumeroTelefone(), getDataNascimento(), getGenero());
    }
}
