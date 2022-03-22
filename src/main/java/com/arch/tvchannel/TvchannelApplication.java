package com.arch.tvchannel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TvchannelApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvchannelApplication.class, args);
    }

}


/*Type type = new Type(1L, "asda");

        typeRepository.save(type);

        Program program = new Program(1L, "asdads", typeRepository.getById(1L));

        programRepository.save(program);*/