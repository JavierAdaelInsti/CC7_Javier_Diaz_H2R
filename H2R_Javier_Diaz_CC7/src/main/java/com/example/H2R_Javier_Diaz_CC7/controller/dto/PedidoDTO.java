package com.example.H2R_Javier_Diaz_CC7.controller.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PedidoDTO {
    @NotNull(message = "El id del producto es obligatorio")
    private Long idproducto;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombreCliente;
}
