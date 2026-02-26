package com.msc_products;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.msc_products.dominio.modelo.Producto;
import com.msc_products.infraestructura.entidad.ProductosEntity;
import com.msc_products.repositorio.ProductoRepository;
import com.msc_products.servicios.ProductoServicio;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class ProductoServiciotTest{

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoServicio service;

    @Test
    void retornarUnProducto() {

        ProductosEntity entity =
                new ProductosEntity("computadora", new BigDecimal("3000"));
        entity.setId(1L);

        when(repository.findById(1L))
                .thenReturn(Optional.of(entity));

        Mono<Producto> resultado = service.obtenerPorId(1L);

        StepVerifier.create(resultado)
                .expectNextMatches(producto ->
                        producto.nombre().equals("computadora") &&
                        producto.precio().compareTo(new BigDecimal("3000")) == 0
                )
                .verifyComplete();
    }
}
