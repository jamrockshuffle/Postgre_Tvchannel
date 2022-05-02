package com.arch.tvchannel.service.type;

import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOUpdate;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import com.arch.tvchannel.service.type.TypeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ExtendWith({MockitoExtension.class})
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan(basePackages = {"com.arch.tvchannel.service"})
@ComponentScan(basePackages = {"com.arch.tvchannel.dao"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeServiceImplTest {

    @Autowired
    @Mock
    TypeRepository typeRepository;

    @Autowired
    @Mock
    TypeServiceImpl service;

    @Test
    @Order(1)
    public void create() throws Exception{

        var type = Type.builder()
                .name("Докуменалка")
                .programs(new HashSet<>())
                .build();

        service.create(type);

        assert type.getId() > 0;

    }

    @Test
    @Order(2)
    public void update() throws Exception{

        var type = Type.builder()
                .id(1L)
                .name("wswwrsdfs")
                .programs(new HashSet<>())
                .build();

        service.update(type);

        assert type.getName().equals("wswwrsdfs");

    }

    @Test
    @Order(3)
    public void findAll() throws Exception{
        create();

        List<Type> list = typeRepository.findAll();

        assert list.size() > 0;
    }

    @Test
    @Order(4)
    public void findById() throws Exception{
        create();

        Type type = typeRepository.findById(1L).get();

        assert type.getId().equals(1L);
    }

    @Test
    @Order(5)
    public void deleteById() throws Exception{
        create();

        typeRepository.deleteById(1L);

        Type type = null;

        Optional<Type> typeOptional = typeRepository.findTypeByName("wswwrsdfs");

        if (typeOptional.isPresent()) {
            type = typeOptional.get();
        }

        assert type == null;
    }

    @Test
    @Order(6)
    public void createDTO() throws Exception{

        TypeDTOCreate dtoCreate = new TypeDTOCreate();
        dtoCreate.setName("asd");

        service.createDTO(dtoCreate);

        assert dtoCreate.getName().equals("asd");

    }

    @Test
    @Order(7)
    public void updateDTO() throws Exception{
        createDTO();

        TypeDTOUpdate dtoUpdate = new TypeDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setName("234234ssdfsdf");

        service.updateDTO(dtoUpdate);

        assert dtoUpdate.getName().equals("234234ssdfsdf");

    }
}