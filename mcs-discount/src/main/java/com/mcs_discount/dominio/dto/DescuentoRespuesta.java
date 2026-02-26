package com.mcs_discount.dominio.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta del cálculo de descuento")
public record DescuentoRespuesta(
		@Schema(description = "Precio original del producto", example = "3000.00")		
		BigDecimal precioOriginal,
		
		@Schema(description = "Precio original del producto", example = "3000.00")
        BigDecimal montoDescontado,
        
        @Schema(description = "Precio final con descuento aplicado", example = "2700.00")
        BigDecimal precioFinal
		) {}
