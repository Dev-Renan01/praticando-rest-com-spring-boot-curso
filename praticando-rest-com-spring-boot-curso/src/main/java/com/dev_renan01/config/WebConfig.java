package com.dev_renan01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// Indica que esta classe é uma classe de configuração do Spring
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Sobrescreve o método responsável por configurar a negociação de conteúdo
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurar) {

        configurar .favorParameter(true) // Permite que o tipo de mídia seja definido por parâmetro na URL
                                         // Exemplo: ?mediaType=json ou ?mediaType=xml
                .parameterName("mediaType") // Define o nome do parâmetro que será usado na URL
                .ignoreAcceptHeader(true) // Ignora o header HTTP "Accept" enviado pelo cliente
                                         // Ou seja, o formato da resposta NÃO será decidido pelo Accept
                .useRegisteredExtensionsOnly(false) // Permite usar extensões que não estejam explicitamente registradas
                .defaultContentType(MediaType.APPLICATION_JSON)// Define o tipo de conteúdo padrão da resposta
                                                              // Caso nenhum parâmetro seja informado, retorna JSON
                .mediaType("json", MediaType.APPLICATION_JSON) // Associa o valor "json" ao tipo de mídia application/json
                .mediaType("xml", MediaType.APPLICATION_XML); // Associa o valor "xml" ao tipo de mídia application/xml

    }
}
