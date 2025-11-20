package com.dev_renan01.service;

import com.dev_renan01.exception.ResourceNotFoundException;
import com.dev_renan01.model.Pessoa;
import com.dev_renan01.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listarTodos(){
       return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id){

        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + id));
    }

    public Pessoa salvar(Pessoa pessoa){

       return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizar(Pessoa pessoa){

       Pessoa entity = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Pessoa não encontrada para o ID: " + pessoa.getId()));

       entity.setNome(pessoa.getNome());
       entity.setSobrenome(pessoa.getSobrenome());
       entity.setEndereco(pessoa.getEndereco());
       entity.setGenero(pessoa.getGenero());

       return entity;
    }




    public void deletarPorId(Long id){

      Pessoa entity = pessoaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Id não encontrado!"));

         pessoaRepository.delete(entity);

    }
}
