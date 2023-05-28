package com.user.cruduser.service;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.cruduser.dto.PersonDTO;
import com.user.cruduser.dto.mapper.PersonMapper;
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
    private final PersonMapper personMapper;

    public Page<Person> list(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public PersonDTO findById(@PathVariable @NotNull UUID id) {
        return personRepository.findById(id).map(personMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public PersonDTO create(@Valid @NotNull PersonDTO person) {
        return personMapper.toDTO(personRepository.save(personMapper.toEntity(person)));
    }

    public PersonDTO update(@NotNull UUID id, @Valid @NotNull PersonDTO person) {
        return personRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(person.name());
                    recordFound.setBirthDate(person.birthDate());
                    recordFound.setCpf(person.cpf());
                    return personMapper.toDTO(personRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull UUID id) {
        personRepository
                .delete(personRepository.findById(id)
                        .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
