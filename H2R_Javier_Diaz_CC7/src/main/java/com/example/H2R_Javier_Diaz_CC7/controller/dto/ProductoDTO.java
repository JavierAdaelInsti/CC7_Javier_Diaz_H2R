package com.example.H2R_Javier_Diaz_CC7.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
        @NotBlank(message = "El nombre es obligatorio")
        private String nombre;
        @NotBlank(message = "La categoria es obligatoria")
        private String categoria;
    }

