package com.user.cruduser.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
 
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(generator = "UUID", strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @NotNull
    @Length(max = 150)
    @Column(length = 150 ,nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Length(max = 11)
    @Column(length = 11, nullable = false)
    private String cpf;

    @NotNull
    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private List<Contact> contacts;

    
}
