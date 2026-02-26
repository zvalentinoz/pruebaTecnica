package com.mcs_discount.dominio.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta del Producto")
// respuesta del Producto  mediate un dto evitamos acoplamiento  
public record ProductoRespuesta( 
		    Long id,
	        String nombre,
	        BigDecimal precio
		) 
{ }
