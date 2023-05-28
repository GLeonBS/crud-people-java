package com.user.cruduser.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.user.cruduser.service.PersonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {
    
    private final PersonService personService;

    @GetMapping
    public @ResponseBody List<Person> list(Pageable pageable) {
        return personService.list(pageable).getContent();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable @NotNull UUID id) {
        return personService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@RequestBody @Valid Person person){
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable @NotNull UUID id, @RequestBody @Valid Person person){
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull UUID id) {
        personService.delete(id);
    }
}
