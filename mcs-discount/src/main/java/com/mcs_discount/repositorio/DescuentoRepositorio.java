package com.mcs_discount.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcs_discount.infraestructura.entidad.DescuentoEntity;

public interface DescuentoRepositorio extends JpaRepository<DescuentoEntity, Long> {

}
