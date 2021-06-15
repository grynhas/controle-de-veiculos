package com.zup.controledeveiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.controledeveiculos.domain.CarDomain;

public interface CarRepository extends JpaRepository<CarDomain, Long> {
	public Optional<CarDomain> findById (Long id);
}
