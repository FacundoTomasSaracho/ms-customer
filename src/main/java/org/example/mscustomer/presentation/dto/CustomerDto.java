package org.example.mscustomer.presentation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(Long id, @NotNull String name, @NotNull @Email String email) {
}
