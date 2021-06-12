package com.zup.controledeveiculos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.controledeveiculos.domain.UserDomain;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
	public Optional<UserDomain> findById (Long id);
}
