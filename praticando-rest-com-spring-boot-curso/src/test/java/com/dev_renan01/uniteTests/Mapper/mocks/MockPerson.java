package com.dev_renan01.uniteTests.Mapper.mocks;

import com.dev_renan01.data.DTO.v1.PessoaDTO;
import com.dev_renan01.model.Pessoa;

import java.util.ArrayList;
import java.util.List;



public class MockPerson {


    public Pessoa mockEntity() {
        return mockEntity(0);
    }
    
    public PessoaDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Pessoa> mockEntityList() {
        List<Pessoa> pessoa = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            pessoa.add(mockEntity(i));
        }
        return pessoa;
    }

    public List<PessoaDTO> mockDTOList() {
        List<PessoaDTO> pessoa = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            pessoa.add(mockDTO(i));
        }
        return pessoa;
    }
    
    public Pessoa mockEntity(Integer number) {
        Pessoa person = new Pessoa();
        person.setEndereco("Endereço Test" + number);
        person.setNome("Nome Test" + number);
        person.setGenero(((number % 2)==0) ? "Macho" : "Femea");
        person.setId(number.longValue());
        person.setSobrenome("Sobrenome Test" + number);
        return person;
    }

    public PessoaDTO mockDTO(Integer number) {
        PessoaDTO person = new PessoaDTO();
        person.setEndereco("Endereço Test" + number);
        person.setNome("Nome Test" + number);
        person.setGenero(((number % 2)==0) ? "Macho" : "Femea");
        person.setId(number.longValue());
        person.setSobrenome("Sobrenome Test" + number);
        return person;
    }

}