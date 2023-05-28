package com.user.cruduser.dto;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record PersonDTO(
                UUID _id,
                @NotEmpty @Length(max = 150, message = "O tamanho máximo é de 150 caracteres") String name,
                @NotEmpty @Length(max = 11, message = "O tamanho máximo é de 11 caracteres") @CPF(message = "CPF inválido") String cpf,
                @NotNull @PastOrPresent(message = "Data inválida, favor não inserir uma data futura") LocalDate birthDate,
                @NotEmpty.List(value = {
                                @NotEmpty(message = "Deve inserir ao menos 1 contato") }) List<ContactDTO> contacts){

}
