package com.user.cruduser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.cruduser.exception.RecordNotFoundException;
import com.user.cruduser.model.Person;
import com.user.cruduser.service.PersonService;

import lombok.AllArgsConstructor;

// @SpringBootTest
// @AllArgsConstructor
// public class PersonServiceTests {
//     private PersonService personService;
//     @Test
//     void deveRetornarQueORegistroNaoFoiEncontrado(){
//         Person person = new Person();
//         person.setName("Leon");
//         personService.delete(person.getId());

//         assertEquals(RecordNotFoundException.class,  personService.delete(person.getId()));
//     }
// }
