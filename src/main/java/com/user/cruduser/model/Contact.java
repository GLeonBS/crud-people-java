package com.user.cruduser.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    @Length(message = "Tamanho do campo excedido, favor inserir menos que 150 caracteres")
    @Column(length = 150, nullable = false)
    @NotEmpty(message = "Campo vazio, favor inserir um nome nos contatos")
    private String name;

    @Length(message = "Tamanho do campo excedido, favor inserir menos que 11 caracteres")
    @Column(length = 11, nullable = false)
    @NotEmpty(message = "Campo vazio, favor inserir um telefone nos contatos")
    private String phoneNumber;

    @Email(message = "Email inválido")
    @Column(length = 150, nullable = false)
    @NotEmpty(message = "Campo vazio, favor inserir um email nos contatos")
    private String email;
}
