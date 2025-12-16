package com.dev_renan01.serialization.converter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

// Classe final que cria um HttpMessageConverter personalizado para YAML
public final class YamlJackson2HttpConverterMensagem extends AbstractJackson2HttpMessageConverter {


    // Configura como o Spring vai converter objetos Java ↔ YAML
    YamlJackson2HttpConverterMensagem() {

        // Chama o construtor da classe pai (AbstractJackson2HttpMessageConverter)
        // 1) Um YAMLMapper (Jackson) para serialização/deserialização
        // 2) O MediaType que esse converter suporta
        super( new YAMLMapper() // YAMLMapper permite trabalhar com YAML em vez de JSON
                        .setSerializationInclusion(JsonInclude.Include.NON_NULL),// Configura para NÃO incluir campos nulos na serialização
                                                                                // Evita gerar atributos com valor null no YAML
                             MediaType.parseMediaType("application/x-yaml") // Define o tipo de mídia aceito pelo converter
                                                                         // Será usado quando o header Accept ou Content-Type for:application/x-yaml
        );
    }
}