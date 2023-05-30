package com.user.cruduser.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.user.cruduser.ApplicationConfigTest;
import com.user.cruduser.dto.mapper.PersonMapper;
import com.user.cruduser.exception.RecordNotFoundException;
import com.user.cruduser.model.Person;
import com.user.cruduser.repository.PersonRepository;

@DisplayName("PersonServiceTest")
class PersonServiceTests extends ApplicationConfigTest {
	@Autowired
	private PersonService personService;

	@MockBean
	private PersonRepository personRepository;

	@MockBean
	private PersonMapper personMapper;

	private final static UUID ID_PERSON = new UUID(45L, 0);
	private final static UUID ID_CONTACT = new UUID(47L, 0);

	@Test
	@DisplayName("Deve retornar que o registro não foi encontrado")
	void deveRetornarQueORegistroNaoFoiEncontrado() {
		Person person = criaPerson();

		assertThrows(RecordNotFoundException.class, () -> personService.delete(person.getId()));
	}

	@Test
	@DisplayName("Deve deletar uma pessoa")
	void deveDeletarUmaPessoa() {
		Optional<Person> person = Optional.of(criaPerson());

		Mockito.when(personRepository.findById(Mockito.any())).thenReturn(person);

		personService.delete(ID_PERSON);

		Mockito.verify(personRepository, Mockito.times(1)).delete(ArgumentMatchers.any(Person.class));
	}

	private Person criaPerson() {
		Person person = Mockito.mock(Person.class);

		Mockito.when(person.getId()).thenReturn(ID_PERSON);
		return person;
	}
}
