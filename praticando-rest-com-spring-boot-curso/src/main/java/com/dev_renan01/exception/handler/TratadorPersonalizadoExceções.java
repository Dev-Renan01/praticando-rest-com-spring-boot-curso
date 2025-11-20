package com.dev_renan01.exception.handler;

import com.dev_renan01.exception.ExceptionResposta;
import com.dev_renan01.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// @ControllerAdvice indica que esta classe vai "vigiar" todos os controllers da aplicação
// Ela serve para centralizar o tratamento de exceções — ou seja, tratar erros em um só lugar
@ControllerAdvice
@RestController
public class TratadorPersonalizadoExceções extends ResponseEntityExceptionHandler {


    // Indica que este método vai capturar QUALQUER exceção do tipo Exception
    // que não tenha sido tratada em outro lugar.
    // Isso faz dele um "tratador global" de exceções genéricas.
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResposta> tratarTodasExcecoes(Exception ex, WebRequest request){
        // Exception - Objeto da exceção que foi lançada (mensagem, tipo, causa, etc.)
       // WebRequest - Informações sobre a requisição HTTP que causou o erro (URI, parâmetros, cabeçalhos)


        // new Date() → registra o momento em que o erro ocorreu.
        // ex.getMessage() → mensagem de erro gerada pela exceção.
        // request.getDescription(false) → detalhes sobre a requisição (ex: URI).
        ExceptionResposta response = new ExceptionResposta(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); // Erro 500 (GENÉRICO)
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResposta> notFoundException(Exception ex, WebRequest request){

        ExceptionResposta response = new ExceptionResposta(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND );
    }






}

