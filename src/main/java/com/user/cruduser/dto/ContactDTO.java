package com.user.cruduser.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record ContactDTO(
        UUID _id,
        @NotEmpty @Length(max = 150)String name,
        @NotEmpty @Length(max = 11)String phoneNumber,
        @NotEmpty @Length(max = 150) @Email String email) {
}
