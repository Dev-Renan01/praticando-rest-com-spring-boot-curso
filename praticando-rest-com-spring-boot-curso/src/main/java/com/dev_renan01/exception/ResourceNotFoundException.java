package com.dev_renan01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    // Permite criar uma nova exceção personalizada informando uma mensagem de erro
    public ResourceNotFoundException(String menssagem){
        // Chama o construtor da classe mãe (RuntimeException)
        // A classe RuntimeException já possui um construtor que recebe uma String
        // Essa String será armazenada internamente e poderá ser recuperada com getMessage()
        super(menssagem);
    }
}
