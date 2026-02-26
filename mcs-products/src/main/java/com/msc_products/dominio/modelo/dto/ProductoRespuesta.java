package com.msc_products.dominio.modelo.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta de un producto")
public record ProductoRespuesta(
        Long id,
        String nombre,
        BigDecimal precio
) {}
