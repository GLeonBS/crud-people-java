package com.user.cruduser.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
public class Contact {
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
    private String phoneNumber;

    @NotBlank
    @NotNull
    @Length(max = 150)
    @Column(length = 150, nullable = false)
    private String email;
}
