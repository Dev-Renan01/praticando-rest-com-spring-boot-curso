package com.dev_renan01.service;

import com.dev_renan01.data.DTO.v1.PessoaDTO;
import com.dev_renan01.data.DTO.v2.PessoaDTOV2;
import com.dev_renan01.exception.ResourceNotFoundException;
import com.dev_renan01.mapper.ObjectMapper;
import com.dev_renan01.mapper.custum.PessoaMapper;
import com.dev_renan01.model.Pessoa;
import com.dev_renan01.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    PessoaMapper converter;


    public List<PessoaDTO> listarTodos(){
       return ObjectMapper.parseListObjects(pessoaRepository.findAll(), PessoaDTO.class);
    }

    public PessoaDTO buscarPorId(Long id){

        var entity =  pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + id));

        return ObjectMapper.parseObject(entity, PessoaDTO.class);
    }

    public PessoaDTO salvar(PessoaDTO pessoa){

        var entity =  ObjectMapper.parseObject(pessoa, Pessoa.class);

        return ObjectMapper.parseObject(pessoaRepository.save(entity), PessoaDTO.class);
    }

    public PessoaDTO atualizar(PessoaDTO pessoa){

        Pessoa entity = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + pessoa.getId()));

       entity.setNome(pessoa.getNome());
       entity.setSobrenome(pessoa.getSobrenome());
       entity.setEndereco(pessoa.getEndereco());
       entity.setGenero(pessoa.getGenero());

       return  ObjectMapper.parseObject(pessoaRepository.save(entity), PessoaDTO.class);
    }

    public void deletarPorId(Long id){

        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id não encontrado!"));

         pessoaRepository.delete(entity);
    }

    //=======================  SERVICES V2 ================================================


    public PessoaDTOV2 salvarV2(PessoaDTOV2 pessoa){

        var entity = converter.convertDTOToEntity(pessoa);

        return converter.convertEntityToDTO((pessoaRepository.save(entity));
    }

    public List<PessoaDTOV2> listarTodosV2(){
        return ObjectMapper.parseListObjects(pessoaRepository.findAll(), PessoaDTOV2.class);
    }

    public PessoaDTOV2 buscarPorIdV2(Long id){

        var entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + id));;

        return ObjectMapper.parseObject(entity, PessoaDTOV2.class);
    }

    public PessoaDTOV2 atualizarV2(PessoaDTOV2 pessoa){

        var entity = pessoaRepository.findById(pessoa.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + pessoa.getId()));

        PessoaMapper pessoaMapper = new PessoaMapper();

        entity.setNome(pessoa.getNome());
        entity.setSobrenome(pessoa.getSobrenome());
        pessoaMapper.convertEntityToDTO(entity);
        //entity.setDataNascimento(new Date());
        entity.setEndereco(pessoa.getEndereco());
        entity.setGenero(pessoa.getGenero());

        return ObjectMapper.parseObject(pessoaRepository.saveAndFlush(entity), PessoaDTOV2.class);
    }

    public void deleteV2(Long id){
        Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id não encontrado!"));

        pessoaRepository.delete(entity);
    }

}