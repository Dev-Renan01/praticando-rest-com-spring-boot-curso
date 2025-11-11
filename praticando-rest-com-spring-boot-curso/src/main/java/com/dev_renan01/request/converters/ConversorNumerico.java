package com.dev_renan01.request.converters;

import com.dev_renan01.exception.OperacaoMatematicaNaoSuportadaException;

public class ConversorNumerico {

    public static double converterDouble(String n) {
        if(n == null || n.isEmpty()){
            throw new OperacaoMatematicaNaoSuportadaException("Parâmetros inválidos. Use apenas números!");
        }
        return Double.parseDouble(n); //retorna  convertendo String para double
    }

    public static boolean isNumeric(String n) { // verificando se é numero
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
