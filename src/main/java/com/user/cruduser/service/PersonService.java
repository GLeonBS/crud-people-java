package com.user.cruduser.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.user.cruduser.exception.RecordNotFoundException;
import com.user.cruduser.model.Person;
import com.user.cruduser.repository.PersonRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Validated
@Service
@AllArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public @ResponseBody Page<Person> list(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public Person findById(@PathVariable @NotNull UUID id) {
        return personRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    public Person create(@Valid Person person){
        return personRepository.save(person);
    }

    public Person update(@NotNull UUID id, @Valid Person person){
        return personRepository.findById(id)
            .map(recordFound ->{
                recordFound.setName(person.getName());
                recordFound.setBirthDate(person.getBirthDate());
                recordFound.setCpf(person.getCpf());
                recordFound.setContacts(person.getContacts());
                return personRepository.save(recordFound);
            }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull UUID id) {
        personRepository
            .delete(personRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
