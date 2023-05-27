package com.user.cruduser.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.user.cruduser.model.Person;
import com.user.cruduser.repository.PersonRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {
    
    private final PersonRepository personRepository;

    @GetMapping
    public @ResponseBody List<Person> lista() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable UUID id) {
        return personRepository.findById(id)
            .map(recordFound -> ResponseEntity.ok().body(recordFound))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody Person person){
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable UUID id, @RequestBody Person person){
        return personRepository.findById(id)
            .map(recordFound ->{
                recordFound.setName(person.getName());
                recordFound.setBirthDate(person.getBirthDate());
                recordFound.setCpf(person.getCpf());
                recordFound.setContacts(person.getContacts());
                Person updated = personRepository.save(recordFound);
                return ResponseEntity.ok().body(updated);
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return personRepository.findById(id)
        .map(recordFound ->{
            personRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
    }
}
