package com.envers.demo;

import com.envers.demo.entity.Pet;
import com.envers.demo.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(PetRepository repository) {
        var pet = Pet.builder().id(123L).age(1).donation(100).name("Savi").build();
        repository.save(pet);
        return args -> log.info("Saved initial pet {} ", pet);
    }

}