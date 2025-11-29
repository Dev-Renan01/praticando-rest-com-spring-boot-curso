package com.dev_renan01.controller;

import com.dev_renan01.data.DTO.v1.PessoaDTO;
import com.dev_renan01.data.DTO.v2.PessoaDTOV2;
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


    //==========================CONTROLLER V2 - VERSIONAMENTO=================================

    @GetMapping(value = "/listarTodosV2")
    @ResponseBody
    public ResponseEntity<List<PessoaDTOV2>> findAllV2(){
        List<PessoaDTOV2> pessoa = pessoaService.listarTodos();

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorIdV2/{id}")
    @ResponseBody
    public ResponseEntity<PessoaDTOV2> findByIdV2(@PathVariable(name = "id") Long id){

        PessoaDTOV2 pessoa = pessoaService.buscarPorIdV2(id);

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @PostMapping(value = "/salvarV2")
    @ResponseBody
    public ResponseEntity<PessoaDTOV2> saveV2(@RequestBody PessoaDTOV2 pessoa){

        PessoaDTOV2 entity = pessoaService.salvar(pessoa);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PutMapping(value = "/atualizarV2")
    @ResponseBody
    public ResponseEntity<PessoaDTOV2> updateV2(@RequestBody PessoaDTOV2 pessoa){

        PessoaDTOV2 entity =  pessoaService.atualizar(pessoa);

        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletarV2/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteByIdV2(@PathVariable(name = "id") Long id){

        pessoaService.deletarPorId(id);

        return  ResponseEntity.noContent().build(); // Retornar o status code 204
    }
}