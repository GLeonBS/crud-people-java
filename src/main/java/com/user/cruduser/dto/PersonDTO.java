package com.user.cruduser.dto;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.user.cruduser.model.Contact;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.util.List;

public record PersonDTO(
        UUID _id,
        @NotEmpty @Length(max = 150)String name,
        @NotEmpty @Length(max = 11) @CPF String cpf,
        @NotNull @PastOrPresent LocalDate birthDate,
        @NotEmpty.List(value = { @NotEmpty }) List<Contact> contacts){

}
