package com.user.cruduser.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Validated
public record ContactDTO(
        UUID _id,
        @NotEmpty(message = "Campo vazio, favor inserir um nome nos contatos") @Length(message = "Tamanho do campo excedido, favor inserir menos que 150 caracteres")String name,
        @NotEmpty(message = "Campo vazio, favor inserir um telefone nos contatos") @Length(message = "Tamanho do campo excedido, favor inserir menos que 11 caracteres")String phoneNumber,
        @NotEmpty(message = "Campo vazio, favor inserir um email nos contatos") @Length(max = 150) @Email(message = "Email inválido") String email) {
}
