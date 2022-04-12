package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dao.type.TypeDAOImpl;
import com.arch.tvchannel.dto.type.TypeDTOCreate;
import com.arch.tvchannel.dto.type.TypeDTOUpdate;
import com.arch.tvchannel.model.Type;
import com.arch.tvchannel.repository.TypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.containsString;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith({MockitoExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeControllerTest {

    @Autowired
    MockMvc mockMvc;

    /*@BeforeEach
    void setup(){

        dao = new TypeDAOImpl(repository);

    }*/

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    // об'єкт конверується в json і передається як requestbody
    // contentType як json (utf8)

    @Test
    @Order(1)
    void create() throws Exception{

        var type = Type.builder()
                .name("aasd")
                .programs(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(type);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/type/create")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString((type.getName()))));


    }


    @Test
    @Order(2)
    void update() throws Exception{

        var type = Type.builder()
                .id(5L)
                .name("Докуменалка")
                .programs(new HashSet<>())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(type);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/type/update")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    @Order(3)
    void getTypes() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/type/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("Серіал")));
    }

    @Test
    @Order(4)
    void getById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/type/get/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
                //.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)));
    }

    @Test
    @Order(5)
    void delete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/type/delete/5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(4)));

    }

    @Test
    @Order(6)
    void createDTO() throws Exception{

        TypeDTOCreate dtoCreate = new TypeDTOCreate();
        dtoCreate.setName("asd");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dtoCreate);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/type/createDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString((dtoCreate.getName()))));


    }

    @Test
    @Order(7)
    void updateDTO() throws Exception{

        TypeDTOUpdate dtoUpdate = new TypeDTOUpdate();
        dtoUpdate.setId(5L);
        dtoUpdate.setName("Докумена123лка");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/type/updateDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}