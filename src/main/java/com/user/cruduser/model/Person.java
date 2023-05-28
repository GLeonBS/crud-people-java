package com.user.cruduser.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    @NotEmpty
    @Length(max = 150)
    @Column(length = 150, nullable = false)
    private String name;

    @NotEmpty
    @Length(max = 11)
    @Column(length = 11, nullable = false)
    @CPF
    private String cpf;

    @NotNull
    @Column(nullable = false)
    @PastOrPresent
    private LocalDate birthDate;

    @NotEmpty.List(value = { @NotEmpty })
    private List<Contact> contacts;

}
