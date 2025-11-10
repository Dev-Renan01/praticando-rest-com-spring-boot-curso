package com.dev_renan01.controller;

import com.dev_renan01.exception.OperacaoMatematicaNaoSuportadaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String saudacoes(){
        return "Olá, seja bem vindo(a) ao meu projeto Spring Boot!";
    }

    @RequestMapping(value = "/soma/{n1}/{n2}")
    // n1 e n2 são Strings porque a URL pode receber qualquer tipo de dado.
    // O método retorna um Double, que é o resultado da soma caso os valores sejam válidos.
    public Double soma(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception {

            if (!isNumeric(n1) || !isNumeric(n2) ) {
                throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!"); //lancar a Exception
            }
            return converterDouble(n1) + converterDouble(n2) ; // Convertendo n1, n2 para double
    }

    private double converterDouble(String n) {
        if(n == null || n.isEmpty()){
            throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!");
        }
        return Double.parseDouble(n); //retorna  convertendo String para double
    }

    private boolean isNumeric(String n) { // verificando se é numero
        if (n == null || n.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(n); // tenta converter a String para double
            return true; // se conseguir retorna true
        } catch (NumberFormatException e) {
            return false; // se der erro, não é número
        }
    }
}
