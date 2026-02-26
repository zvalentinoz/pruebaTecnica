package com.msc_products.dominio.modelo;

import java.math.BigDecimal;

public record Producto(
        Long id,
        String nombre,
        BigDecimal precio
){
	
}