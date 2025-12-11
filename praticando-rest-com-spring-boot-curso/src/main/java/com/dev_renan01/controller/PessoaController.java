package com.dev_renan01.controller;

import com.dev_renan01.data.DTO.PessoaDTO;
import com.dev_renan01.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/listarTodos")
    @ResponseBody
    public List<PessoaDTO> findAll(){
        return pessoaService.listarTodos();
    }

    @GetMapping(value = "/buscarPorId/{id}")
    @ResponseBody
    public PessoaDTO findById(@PathVariable(name = "id") Long id){
        var pessoa =  pessoaService.buscarPorId(id);
        pessoa.setDataNascimento(new Date());
        return pessoa;
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public PessoaDTO save(@RequestBody PessoaDTO pessoa){
        return pessoaService.salvar(pessoa);
    }

    @PutMapping(value = "/atualizar")
    @ResponseBody
    public PessoaDTO update(@RequestBody PessoaDTO pessoa){
        return pessoaService.atualizar(pessoa);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){

        pessoaService.deletarPorId(id);

        return  ResponseEntity.noContent().build(); // Retornar o status code 204
    }

}