package com.user.cruduser.dto.mapper;

import org.springframework.stereotype.Component;

import com.user.cruduser.dto.PersonDTO;
import com.user.cruduser.model.Person;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PersonMapper {

    private ContactMapper contactMapper;

    public PersonDTO toDTO(Person person) {
        if (person == null) {
            return null;
        }
        return new PersonDTO(person.getId(), person.getName(), person.getCpf(), person.getBirthDate(),
                contactMapper.toListContactsDTO(person.getContacts()));
    }

    public Person toEntity(PersonDTO personDTO) {
        if (personDTO == null) {
            return null;
        }
        Person person = new Person();
        if (personDTO._id() != null) {
            person.setId(personDTO._id());
        }
        person.setName(personDTO.name());
        person.setCpf(personDTO.cpf());
        person.setBirthDate(personDTO.birthDate());
        person.setContacts(contactMapper.toListContactsEntity(personDTO.contacts()));
        return person;
    }
}
