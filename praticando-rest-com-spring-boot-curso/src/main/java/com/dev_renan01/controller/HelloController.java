package com.dev_renan01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/saudacoes")
public class HelloController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String saudacoes(){
        return "Olá, seja bem vindo(a) ao meu projeto Spring Boot!";
    }
}
