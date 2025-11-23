package com.dev_renan01.controller;

import com.dev_renan01.data.DTO.PessoaDTO;
import com.dev_renan01.mapper.ObjectMapper;
import com.dev_renan01.model.Pessoa;
import com.dev_renan01.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/listarTodos")
    @ResponseBody
    public ResponseEntity<List<PessoaDTO>> findAll(){
       List<PessoaDTO> pessoa = pessoaService.listarTodos();

       return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorId/{id}")
    @ResponseBody
    public ResponseEntity<PessoaDTO> findById(@PathVariable(name = "id") Long id){

        PessoaDTO pessoa = pessoaService.buscarPorId(id);

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoa){

        PessoaDTO entity = pessoaService.salvar(pessoa);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PutMapping(value = "/atualizar")
    @ResponseBody
    public ResponseEntity<PessoaDTO> update(@RequestBody PessoaDTO pessoa){

        PessoaDTO entity =  pessoaService.atualizar(pessoa);

       return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){

        pessoaService.deletarPorId(id);

        return  ResponseEntity.noContent().build(); // Retornar o status code 204
    }
}