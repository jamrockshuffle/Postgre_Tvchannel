package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.program.ProgramDAOImpl;
import com.arch.tvchannel.dao.type.TypeDAOImpl;
import com.arch.tvchannel.dto.program.ProgramDTOCreate;
import com.arch.tvchannel.dto.program.ProgramDTOUpdate;
import com.arch.tvchannel.model.Program;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.ProgramRepository;
import com.arch.tvchannel.repository.TypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.HashSet;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProgramControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    @Mock
    TypeRepository typeRepository;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    @Order(1)
    void create() throws Exception{

        var program = Program.builder()
                .name("teste")
                .type(typeRepository.findById(2L).get())
                .monday(new HashSet<>())
                .tuesday(new HashSet<>())
                .wednesday(new HashSet<>())
                .thursday(new HashSet<>())
                .friday(new HashSet<>())
                .saturday(new HashSet<>())
                .sunday(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(program);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/program/create")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString((program.getName()))));


    }

    @Test
    @Order(2)
    void update() throws Exception{

        var program = Program.builder()
                .id(4L)
                .name("Краще Подзвоніть Солу")
                .type(typeRepository.findById(2L).get())
                .monday(new HashSet<>())
                .tuesday(new HashSet<>())
                .wednesday(new HashSet<>())
                .thursday(new HashSet<>())
                .friday(new HashSet<>())
                .saturday(new HashSet<>())
                .sunday(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(program);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/program/update")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    @Order(3)
    void getPrograms() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/program/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name", Matchers.is("Вейкфілд")));
    }

    @Test
    @Order(4)
    void getById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/program/get/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    @Order(5)
    void delete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/program/delete/4"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(3)));

    }

    @Test
    @Order(6)
    void createDTO() throws Exception{

        ProgramDTOCreate dtoCreate = new ProgramDTOCreate();
        dtoCreate.setName("1231231sdada");
        dtoCreate.setType(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dtoCreate);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/program/createDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString((dtoCreate.getName()))));


    }

    @Test
    @Order(7)
    void updateDTO() throws Exception{

        ProgramDTOUpdate dtoUpdate = new ProgramDTOUpdate();
        dtoUpdate.setId(4L);
        dtoUpdate.setName("sadasd");
        dtoUpdate.setType(2L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/program/updateDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}