package com.msc_products.dominio.modelo.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Petición para crear producto")
public record ProductoPeticion(

		@Schema(description = "Nombre del producto", example = "Laptop Gamer")
        @NotBlank
        String nombre,

        @Schema(description = "Precio del producto", example = "3000.00")
        @NotNull
        BigDecimal precio
) {}
