package com.msc_products;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.msc_products.controladores.ProductoControlador;
import com.msc_products.dominio.modelo.Producto;
import com.msc_products.servicios.ProductoServicio;

import reactor.core.publisher.Mono;

@WebFluxTest(ProductoControlador.class)
class ProductoControladorTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ProductoServicio service;

    @Test
    void RetornarProductoPorId() {

        Producto producto = new Producto(
                1L,
                "computadora",
                new BigDecimal("3000")
        );

        when(service.obtenerPorId(1L))
                .thenReturn(Mono.just(producto));

        webTestClient.get()
                .uri("/api/productos/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("computadora")
                .jsonPath("$.precio").isEqualTo(3000);
    }
}
