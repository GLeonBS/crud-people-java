package com.user.cruduser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.user.cruduser.dto.PersonDTO;
import com.user.cruduser.dto.mapper.PersonMapper;
import com.user.cruduser.exception.RecordNotFoundException;
import com.user.cruduser.model.Contact;
import com.user.cruduser.model.Person;
import com.user.cruduser.repository.PersonRepository;
import com.user.cruduser.service.PersonService;

@SpringBootTest
class PersonServiceTests {
    @InjectMocks
	private PersonService personService;

	@Mock
	private PersonDTO personDTO;

	@Mock
	private PersonRepository personRepository;

	@Mock
	private PersonMapper personMapper;
    
    private final static UUID ID_PERSON = new UUID(45L, 0);

    @Test
    void deveRetornarQueORegistroNaoFoiEncontrado(){
        Person person = new Person();
        person.setId(ID_PERSON);
        person.setName("Leon");

        assertThrows(RecordNotFoundException.class, () -> personService.delete(person.getId()));
    }


    @Test
	void testListPeoplePaginated(){
		UUID id = new UUID(45L, 0);
		UUID idC = new UUID(46L, 0);

		Contact c1 = new Contact();
		c1.setId(idC);
		c1.setName("Leon");
		c1.setPhoneNumber("44998698981");
		c1.setEmail("gabriel.leonbs@gmail.com");
		List<Contact> contacts = new ArrayList<>();
		contacts.add(c1);

        Person person = new Person();
		person.setId(id);
		person.setBirthDate(LocalDate.now());
		person.setCpf("08283089935");
		person.setName("Leon");
		person.setContacts(contacts);

		PersonDTO personDTO = personMapper.toDTO(person);
		
		personService.create(personDTO);

        List<Person> list = new ArrayList<>();
        list.add(person);
		
		Pageable pageable = PageRequest.of(0, 2);
		Page<PersonDTO> pagePerson = personService.list(pageable);
        pagePerson.stream().map(cont -> {
            return cont = personDTO;
        });


		assertEquals(1, pagePerson.getContent().size());
	}
}
