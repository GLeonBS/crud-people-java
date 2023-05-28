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

    @NotEmpty
    @Length(max = 150)
    @Column(length = 150, nullable = false)
    private String name;

    @NotEmpty
    @Length(max = 11)
    @Column(length = 11, nullable = false)
    private String phoneNumber;

    @NotEmpty
    @Length(max = 150)
    @Column(length = 150, nullable = false)
    @Email
    private String email;
}
