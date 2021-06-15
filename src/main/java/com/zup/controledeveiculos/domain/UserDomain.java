package com.zup.controledeveiculos.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "users")
public class UserDomain {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_user")
	    private Long id;

	    @Column(name = "first_name", nullable = false)
	    private String firstName;

	    @Column(name = "email", unique = true, nullable = false)
	    private String email;

	    @Column(name = "cpf", unique = true, nullable = false)
	    private String cpf;

	    @Column(name = "birth_date")
	    private LocalDateTime birthDate;

	    @OneToMany (mappedBy = "users")
	    @JsonManagedReference
	    private Set<CarDomain> cars;

		public Long getId() {
			return id;
		}

		public String getFirstName() {
			return firstName;
		}

		public String getEmail() {
			return email;
		}

		public String getCpf() {
			return cpf;
		}

		public LocalDateTime getBirthDate() {
			return birthDate;
		}

		public Set<CarDomain> getCars() {
			return cars;
		}

}
