package com.user.cruduser.service;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.user.cruduser.ApplicationConfigTest;
import com.user.cruduser.dto.mapper.PersonMapper;
import com.user.cruduser.exception.RecordNotFoundException;
import com.user.cruduser.model.Person;
import com.user.cruduser.repository.PersonRepository;

@DisplayName("PersonServiceTest")
class PersonServiceTests extends ApplicationConfigTest {
	@InjectMocks
	private PersonService personService;

	@Mock
	private PersonRepository personRepository;

	@Mock
	private PersonMapper personMapper;

	private final static UUID ID_PERSON = new UUID(45L, 0);

	@Test
	@DisplayName("Deve retornar que o registro não foi encontrado quando tentar deletar uma pessoa que não existe")
	void deveRetornarQueORegistroNaoFoiEncontradoQuandoTentarDeletarUmaPessoaQueNãoExiste() {
		Person person = createPerson();

		assertThrowsExactly(RecordNotFoundException.class, () -> personService.delete(person.getId()));
	}

	@Test
	@DisplayName("Deve deletar uma pessoa")
	void deveDeletarUmaPessoa() {
		Optional<Person> person = Optional.of(createPerson());

		Mockito.when(personRepository.findById(Mockito.any())).thenReturn(person);

		personService.delete(ID_PERSON);

		Mockito.verify(personRepository, Mockito.times(1)).delete(ArgumentMatchers.any(Person.class));
	}

	@Test
	@DisplayName("Deve retornar que o registro não foi encontrado quando tentar encontrar uma pessoa que não existe")
	void deveRetornarQueORegistroNaoFoiEncontradoQuandoTentarEncontrarUmaPessoaQueNãoExiste() {
		Person person = createPerson();

		assertThrowsExactly(RecordNotFoundException.class, () -> personService.findById(person.getId()));
	}

	@Test
	@DisplayName("Deve retornar que o registro não foi encontrado quando tentar alterar uma pessoa que não existe")
	void deveRetornarQueORegistroNaoFoiEncontradoQuandoTentarAlterarUmaPessoaQueNãoExiste() {
		Person person = createPerson();

		assertThrowsExactly(RecordNotFoundException.class, () -> personService.update(person.getId(), personMapper.toDTO(person)));
	}

	private Person createPerson() {
		Person person = Mockito.mock(Person.class);

		Mockito.when(person.getId()).thenReturn(ID_PERSON);
		return person;
	}
}
