package com.dev_renan01.controller;

import com.dev_renan01.exception.OperacaoMatematicaNaoSuportadaException;
import com.dev_renan01.request.converters.ConversorNumerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperacoesController {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String saudacoes(){
        return "Olá, seja bem vindo(a) ao meu projeto Spring Boot!";
    }

    @RequestMapping(value = "/soma/{n1}/{n2}")
    // n1 e n2 são Strings porque a URL pode receber qualquer tipo de dado.
    // O método retorna um Double, que é o resultado da soma caso os valores sejam válidos.
    public Double soma(@PathVariable("n1") String n1, @PathVariable("n2") String n2) throws Exception {

            if (!ConversorNumerico.isNumeric(n1) || !ConversorNumerico.isNumeric(n2) ) {
                throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!"); //lancar a Exception
            }
            return ConversorNumerico.converterDouble(n1) + ConversorNumerico.converterDouble(n2) ; // Convertendo n1, n2 para double
    }


    @RequestMapping(value = "/subtracao/{n1}/{n2}")
    public Double subtracao(@PathVariable("n1") String n1, @PathVariable("n2") String n2){

        if(!ConversorNumerico.isNumeric(n1) || !ConversorNumerico.isNumeric(n2)){
            throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!");
        }
        return ConversorNumerico.converterDouble(n1) - ConversorNumerico.converterDouble(n2);
    }

    @RequestMapping(value = "/multiplicacao/{n1}/{n2}")
    public Double multiplicacao(@PathVariable("n1") String n1, @PathVariable("n2") String n2){

        if(!ConversorNumerico.isNumeric(n1) || !ConversorNumerico.isNumeric(n2)){
            throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!");
        }
        return ConversorNumerico.converterDouble(n1) * ConversorNumerico.converterDouble(n2);
    }

    @RequestMapping(value = "/divisao/{n1}/{n2}")
    public Double divisao(@PathVariable("n1") String n1, @PathVariable("n2") String n2){

        if(!ConversorNumerico.isNumeric(n1) || !ConversorNumerico.isNumeric(n2)){
            throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!");
        }
        return ConversorNumerico.converterDouble(n1) / ConversorNumerico.converterDouble(n2);
    }

    @RequestMapping(value = "/media/{n1}/{n2}")
    public Double media(@PathVariable("n1") String n1, @PathVariable("n2") String n2){
        if(!ConversorNumerico.isNumeric(n1) || !ConversorNumerico.isNumeric(n2)){
            throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!");
        }
        return (ConversorNumerico.converterDouble(n1) + ConversorNumerico.converterDouble(n2)) / 2;
    }
}
