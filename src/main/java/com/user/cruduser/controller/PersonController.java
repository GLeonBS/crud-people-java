package com.user.cruduser.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.user.cruduser.model.Person;
import com.user.cruduser.repository.PersonRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/persons")
@AllArgsConstructor
public class PersonController {
    
    private final PersonRepository userRepository;

    @GetMapping
    public List<Person> lista() {
        return userRepository.findAll();
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            userRepository.deleteAll();
            Person u = new Person();
            u.setNome("Spring");
            u.setCpf("08283089935");
            u.setDataNascimento(LocalDate.of(2023, 5, 23));
            // u.setContatos(cont);
            userRepository.save(u);
        };
    }
}
