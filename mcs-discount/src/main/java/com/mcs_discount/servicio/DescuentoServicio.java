package com.mcs_discount.servicio;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.mcs_discount.clientes.ProductoCliente;
import com.mcs_discount.dominio.excepcion.ExcepcionDescuento;
import com.mcs_discount.dominio.modelo.Descuento;
import com.mcs_discount.infraestructura.entidad.DescuentoEntity;
import com.mcs_discount.repositorio.DescuentoRepositorio;

import reactor.core.publisher.Mono;

@Service
public class DescuentoServicio {

    private final ProductoCliente cliente;
    private final DescuentoRepositorio repository;

    public DescuentoServicio(ProductoCliente cliente,
                             DescuentoRepositorio repository) {
        this.cliente = cliente;
        this.repository = repository;
    }

    public Mono<Descuento> calcularDescuento(Long productoId) {

        return cliente.obtenerProducto(productoId)
                .map(producto -> {
                    BigDecimal precio = producto.precio(); // debe coincidir con ProductoRespuesta
                    BigDecimal factor = precio.compareTo(BigDecimal.valueOf(1500)) > 0
                            ? BigDecimal.valueOf(0.9)
                            : BigDecimal.valueOf(0.95);

                    BigDecimal precioFinal = precio.multiply(factor)
                                                   .setScale(2, RoundingMode.HALF_UP);

                    return new DescuentoEntity(productoId, precio, precioFinal);
                })
                .flatMap(entity -> Mono.fromSupplier(() -> repository.save(entity)))
                .map(entity -> new Descuento(
                        entity.getId(),
                        entity.getProductoId(),
                        entity.getPrecioOriginal(),
                        entity.getPrecioFinal()
                ))
                .onErrorMap(e -> new ExcepcionDescuento("No se pudo calcular descuento: " + e.getMessage()));
    }

	    
}
