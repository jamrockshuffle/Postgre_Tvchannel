package com.arch.tvchannel.controller.rest;

import com.arch.tvchannel.dto.day.DayDTOCreate;
import com.arch.tvchannel.dto.day.DayDTOUpdate;
import com.arch.tvchannel.model.Monday;
import com.arch.tvchannel.model.Tuesday;
import com.arch.tvchannel.repository.ProgramRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
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
import java.time.LocalTime;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TuesdayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    @Mock
    ProgramRepository programRepository;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    void create() throws Exception{

        var day = Tuesday.builder()
                .airingTime(LocalTime.of(12,00))
                .program(programRepository.findById(2L).get())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(day);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/tuesday/create")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString((day.getProgram().getName()))));


    }


    @Test
    void update() throws Exception{

        var day = Tuesday.builder()
                .id(1L)
                .airingTime(LocalTime.of(11,00))
                .program(programRepository.findById(1L).get())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(day);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/tuesday/update")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void getTypes() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tuesday/get/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)));
    }

    @Test
    void getById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tuesday/get/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void delete() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tuesday/delete/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(0)));

    }

    @Test
    void createDTO() throws Exception{

        DayDTOCreate dtoCreate = new DayDTOCreate();
        dtoCreate.setAiringTime("12:00");
        dtoCreate.setProgram(1L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dtoCreate);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/tuesday/createDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    void updateDTO() throws Exception{

        DayDTOUpdate dtoUpdate = new DayDTOUpdate();
        dtoUpdate.setId(1L);
        dtoUpdate.setAiringTime("13:00");
        dtoUpdate.setProgram(2L);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dtoUpdate);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/tuesday/updateDTO")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}