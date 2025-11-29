package com.dev_renan01.mapper.custum;

import com.dev_renan01.data.DTO.v2.PessoaDTOV2;
import com.dev_renan01.model.Pessoa;
import com.dev_renan01.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaMapper {

    public PessoaDTOV2 convertEntityToDTO(Pessoa pessoa){ // Converter entidade para DTO

        PessoaDTOV2 dto = new PessoaDTOV2();

        dto.setNome(pessoa.getNome());
        dto.setSobrenome(pessoa.getSobrenome());
        dto.setDataNascimento(new Date());
        dto.setEndereco(pessoa.getEndereco());
        dto.setGenero(pessoa.getGenero());
        return dto;
    }

    public Pessoa convertDTOToEntity(PessoaDTOV2 pessoaDTOv2){ // Converter DTO para entidade

        Pessoa pessoa = new Pessoa();

        pessoa.setNome(pessoa.getNome());
        pessoa.setSobrenome(pessoa.getSobrenome());
        //pessoa.setDataNascimento(new Date());
        pessoa.setEndereco(pessoa.getEndereco());
        pessoa.setGenero(pessoa.getGenero());
        return pessoa;
    }
}
