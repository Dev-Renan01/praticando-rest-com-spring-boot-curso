package com.dev_renan01.exception;

import java.util.Date;
// Classe usada para representar o formato de resposta de erro da API
// Ela será retornada quando ocorrer uma exceção tratada (por exemplo, IllegalArgumentException)
public class ExceptionResponse {

   private Date dataHora;  // Data e hora em que a exceção ocorreu
   private String mensagem; // Mensagem principal do erro
   private String detalhe;   // Detalhes adicionais do erro

    public ExceptionResponse (Date dataHora, String mensagem, String detalhe){
        this.dataHora = dataHora;
        this.mensagem = mensagem;
        this.detalhe = detalhe;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }
}
