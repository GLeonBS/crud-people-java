package com.user.cruduser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.user.cruduser.dto.PersonDTO;
import com.user.cruduser.dto.mapper.PersonMapper;
import com.user.cruduser.model.Contact;
import com.user.cruduser.model.Person;
import com.user.cruduser.service.PersonService;

import lombok.AllArgsConstructor;

@SpringBootTest
@AllArgsConstructor
class CrudUserApplicationTests {
	PersonService personService;
	PersonMapper personMapper;

	@Test
	void testListPeoplePaginated(){
		Pageable pageable = PageRequest.of(0, 1);
		Person person = new Person();
		UUID id = new UUID(45L, 0);
		UUID idC = new UUID(46L, 0);
		Contact c1 = new Contact();
		c1.setId(idC);
		c1.setName("Leon");
		c1.setPhoneNumber("44998698981");
		c1.setEmail("gabriel.leonbs@gmail.com");
		List<Contact> contacts = new ArrayList<>();
		contacts.add(c1);
		person.setId(id);
		person.setBirthDate(LocalDate.now());
		person.setCpf("08283089935");
		person.setName("Leon");
		person.setContacts(contacts);

		
		PersonDTO personDTO = personMapper.toDTO(person);
		
		personService.create(personDTO);

		Page<Person> pagePerson = personService.list(pageable);


		assertEquals(1, pagePerson.getContent().size());
	}

}
