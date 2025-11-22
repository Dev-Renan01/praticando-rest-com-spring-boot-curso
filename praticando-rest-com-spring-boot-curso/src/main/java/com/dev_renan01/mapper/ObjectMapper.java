package com.dev_renan01.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

/* Classe utilitária criada para centralizar o uso do Dozer no projeto.
 Ela mantém uma instância estática de 'Mapper', que é o objeto responsável
 por converter (mapear) um tipo de classe para outro, como DTO <-> Entity.*/
public class ObjectMapper {

    /* cria uma configuração padrão do Dozer,
     carregando automaticamente qualquer arquivo de mapeamento (dozer-mapping.xml) caso exista.
     O uso de um Mapper estático evita criar novas instâncias toda vez que você
     precisar converter objetos, já que o Dozer é relativamente pesado.*/
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);// Converte um objeto de origem (origin) em outro tipo de objeto (destination),
        //utilizando o 'mapper' do Dozer.
    }

    public static <O, D> List<D> parseListObject(List<O> origin, Class<D> destination) {
       // Converte uma lista de objetos de origem em uma lista de objetos de destino
        // usando o Dozer como mecanismo de mapeamento.

        List<D> destinatioObject = new ArrayList<D>();

        for (Object o : origin) {
            destinatioObject.add(mapper.map(o, destination));

        }
        return destinatioObject;
    }
}
