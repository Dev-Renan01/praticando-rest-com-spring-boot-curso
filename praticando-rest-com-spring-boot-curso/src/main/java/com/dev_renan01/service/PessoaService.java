package com.dev_renan01.service;

import com.dev_renan01.controller.PessoaController;
import com.dev_renan01.data.DTO.PessoaDTO;
import com.dev_renan01.exception.ResourceNotFoundException;
import com.dev_renan01.mapper.ObjectMapper;
import com.dev_renan01.model.Pessoa;
import com.dev_renan01.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dev_renan01.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<PessoaDTO> listarTodos() {
        return ObjectMapper.parseListObjects(pessoaRepository.findAll(), PessoaDTO.class);
    }

    public PessoaDTO buscarPorId(Long id) {

        var entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + id));
        var dto = parseObject(entity, PessoaDTO.class);
        return parseObject(entity, PessoaDTO.class);
        extracted(id, dto);
    }

    private static void extracted(Long id, PessoaDTO dto) {
        dto.add(linkTo(methodOn(PessoaController.class).findById(id)).whithSelfRel().whithType("GET"));
    }

    public PessoaDTO salvar(PessoaDTO pessoa) {

        var entity = parseObject(pessoa, Pessoa.class);

        return parseObject(pessoaRepository.save(entity), PessoaDTO.class);
    }

    public PessoaDTO atualizar(PessoaDTO pessoa) {

        Pessoa entity = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + pessoa.getId()));

        entity.setNome(pessoa.getNome());
        entity.setSobrenome(pessoa.getSobrenome());
        entity.setEndereco(pessoa.getEndereco());
        entity.setGenero(pessoa.getGenero());

        return parseObject(pessoaRepository.save(entity), PessoaDTO.class);
    }

    public void deletarPorId(Long id) {

        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado!"));

        pessoaRepository.delete(entity);
    }
}