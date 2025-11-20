package com.dev_renan01.controller;

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
    public ResponseEntity<List<Pessoa>> findAll(){
       List<Pessoa> pessoa = pessoaService.listarTodos();

       return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorId/{id}")
    @ResponseBody
    public ResponseEntity<Pessoa> findById(@PathVariable(name = "id") Long id){

        Pessoa pessoa = pessoaService.buscarPorId(id);

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){

        Pessoa entity = pessoaService.salvar(pessoa);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PutMapping(value = "/atualizar")
    @ResponseBody
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){

       Pessoa entity =  pessoaService.atualizar(pessoa);

       return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id){

        pessoaService.deletarPorId(id);

        return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.OK);
    }

}