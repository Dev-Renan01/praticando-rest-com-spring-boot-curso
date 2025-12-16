package com.dev_renan01.controller;

import com.dev_renan01.data.DTO.PessoaDTO;
import com.dev_renan01.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
                                        // Indica o tipo de mídia que a API irá retornar, ex: JSON, XML
    @GetMapping(value = "/listarTodos",
            produces = {
                 MediaType.APPLICATION_JSON_VALUE,
                 MediaType.APPLICATION_XML_VALUE,
                 MediaType.APPLICATION_YAML_VALUE},
            consumes = {
                 MediaType.APPLICATION_JSON_VALUE,
                 MediaType.APPLICATION_XML_VALUE,
                 MediaType.APPLICATION_YAML_VALUE}
    )
    public List<PessoaDTO> findAll(){
        return pessoaService.listarTodos();
    }

    @GetMapping(value = "/buscarPorId/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    public PessoaDTO findById(@PathVariable(name = "id") Long id){
        var pessoa =  pessoaService.buscarPorId(id);
        pessoa.setDataNascimento(new Date());
        pessoa.setNumeroTelefone("(81) 9xxxx-xxxx");
        return pessoa;
    }

    @PostMapping(value = "/salvar",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    public PessoaDTO save(@RequestBody PessoaDTO pessoa){
        return pessoaService.salvar(pessoa);
    }
    @PutMapping(value = "/atualizar",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )

    public PessoaDTO update(@RequestBody PessoaDTO pessoa){
        return pessoaService.atualizar(pessoa);
    }

    @DeleteMapping(value = "/deletar/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE},
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_YAML_VALUE}
    )
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id){

        pessoaService.deletarPorId(id);

        return  ResponseEntity.noContent().build(); // Retornar o status code 204
    }

}