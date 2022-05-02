package com.arch.tvchannel.service.thursday;

import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.dto.program.ProgramDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Thursday;
import com.arch.tvchannel.repository.MondayRepository;
import com.arch.tvchannel.repository.ThursdayRepository;
import com.arch.tvchannel.service.monday.MondayServiceImpl;
import com.arch.tvchannel.service.program.ProgramServiceImpl;
import com.arch.tvchannel.service.type.TypeServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan(basePackages = {"com.arch.tvchannel.service"})
@ComponentScan(basePackages = {"com.arch.tvchannel.dao"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ThursdayServiceImplTest {

    @Autowired
    @Mock
    ThursdayRepository repository;

    @Autowired
    @Mock
    ThursdayServiceImpl service;

    @Autowired
    @Mock
    TypeServiceImpl typeService;

    @Autowired
    @Mock
    ProgramServiceImpl programService;

    @Test
    @Order(1)
    public void create() throws Exception{

        var day = Thursday.builder()
                .airingTime(LocalTime.of(12,00))
                .program(null)
                .build();

        service.create(day);

        assert day.getId() > 0;

    }

    @Test
    @Order(2)
    public void update() throws Exception{
        create();

        var day = Thursday.builder()
                .id(1L)
                .airingTime(LocalTime.of(11,00))
                .program(null)
                .build();

        service.update(day);

        assert day.getAiringTime().equals(LocalTime.of(11,00));

    }

    @Test
    @Order(3)
    public void findAll() throws Exception{
        create();

        List<Thursday> list = repository.findAll();

        assert list.size() > 0;
    }


    @Test
    @Order(4)
    public void findById() throws Exception{
        create();

        Thursday day = repository.findById(1L).get();

        assert day.getId().equals(1L);
    }

    @Test
    @Order(5)
    public void deleteById() throws Exception{
        create();

        repository.deleteById(1L);

        Thursday day = null;

        Optional<Thursday> optional = repository.findById(1L);

        if (optional.isPresent()) {
            day = optional.get();
        }

        assert day == null;
    }

    @Test
    @Order(6)
    public void createDTO() throws Exception{

        TypeDTOCreate dtoCreate = new TypeDTOCreate();
        dtoCreate.setName("typetest");

        typeService.createDTO(dtoCreate);

        ProgramDTOCreate dtoCreate1 = new ProgramDTOCreate();
        dtoCreate1.setName("asd");
        dtoCreate1.setType(1L);

        programService.createDTO(dtoCreate1);

        DayDTOCreate dtoCreate2 = new DayDTOCreate();
        dtoCreate2.setAiringTime("12:00");
        dtoCreate2.setProgram(1L);

        service.createDTO(dtoCreate2);

        assert dtoCreate2.getAiringTime().equals("12:00");

    }

    @Test
    @Order(7)
    public void updateDTO() throws Exception{
        createDTO();

        DayDTOUpdate dtoUpdate = new DayDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setAiringTime("13:00");
        dtoUpdate.setProgram(1L);

        service.updateDTO(dtoUpdate);

        assert dtoUpdate.getAiringTime().equals("13:00");

    }

}