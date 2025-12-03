package com.dev_renan01.uniteTests.Mapper;

import com.dev_renan01.data.DTO.PessoaDTO;
import com.dev_renan01.model.Pessoa;
import com.dev_renan01.uniteTests.Mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.dev_renan01.mapper.ObjectMapper.parseListObjects;
import static com.dev_renan01.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperTests {

    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test // Testa a conversão de uma entidade Pessoa para PessoaDTO.
    public void parseEntityToDTOTest() { //O teste valida: Se o ID foi copiado corretamente.
                                         //Se o nome, sobrenome, endereço e gênero foram mapeados como esperado.
        PessoaDTO output = parseObject(inputObject.mockEntity(), PessoaDTO.class);

        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Nome Test0", output.getNome());
        assertEquals("Sobrenome Test0", output.getSobrenome());
        assertEquals("Endereço Test0", output.getEndereco());
        assertEquals("Macho", output.getGenero());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<PessoaDTO> outputList = parseListObjects(inputObject.mockEntityList(), PessoaDTO.class);

        PessoaDTO output0 = outputList.get(0);

        assertEquals(Long.valueOf(0L), output0.getId());
        assertEquals("Nome Test0", output0.getNome());
        assertEquals("Sobrenome Test0", output0.getSobrenome());
        assertEquals("Endereço Test0", output0.getEndereco());
        assertEquals("Macho", output0.getGenero());

        PessoaDTO output7 = outputList.get(7);

        assertEquals(Long.valueOf(7L), output7.getId());
        assertEquals("Nome Test7", output7.getNome());
        assertEquals("Sobrenome Test7", output7.getSobrenome());
        assertEquals("Endereço Test7", output7.getEndereco());
        assertEquals("Femea", output7.getGenero());

        PessoaDTO output12 = outputList.get(12);

        assertEquals(Long.valueOf(12L), output12.getId());
        assertEquals("Nome Test12", output12.getNome());
        assertEquals("Sobrenome Test12", output12.getSobrenome());
        assertEquals("Endereço Test12", output12.getEndereco());
        assertEquals("Macho", output12.getGenero());
    }

    @Test
    public void parseDTOToEntityTest() {
        Pessoa output = parseObject(inputObject.mockDTO(), Pessoa.class);

        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Nome Test0", output.getNome());
        assertEquals("Sobrenome Test0", output.getSobrenome());
        assertEquals("Endereço Test0", output.getEndereco());
        assertEquals("Macho", output.getGenero());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Pessoa> outputList = parseListObjects(inputObject.mockDTOList(), Pessoa.class);
        Pessoa output0 = outputList.get(0);

        assertEquals(Long.valueOf(0L), output0.getId());
        assertEquals("Nome Test0", output0.getNome());
        assertEquals("Sobrenome Test0", output0.getSobrenome());
        assertEquals("Endereço Test0", output0.getEndereco());
        assertEquals("Macho", output0.getGenero());

        Pessoa output7 = outputList.get(7);

        assertEquals(Long.valueOf(7L), output7.getId());
        assertEquals("Nome Test7", output7.getNome());
        assertEquals("Sobrenome Test7", output7.getSobrenome());
        assertEquals("Endereço Test7", output7.getEndereco());
        assertEquals("Femea", output7.getGenero());

        Pessoa output12 = outputList.get(12);

        assertEquals(Long.valueOf(12L), output12.getId());
        assertEquals("Nome Test12", output12.getNome());
        assertEquals("Sobrenome Test12", output12.getSobrenome());
        assertEquals("Endereço Test12", output12.getEndereco());
        assertEquals("Macho", output12.getGenero());
    }
}