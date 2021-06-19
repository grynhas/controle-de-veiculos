package com.zup.controledeveiculos.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table (name = "users")
public class UserDomain {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_user")
	    private Long idUser;

	    @Column(nullable = false)
	    private String name;

	    @Column(unique = true, nullable = false)
	    private String email;

	    @Column(unique = true, nullable = false)
	    private String cpf;

	    @Column
	    @JsonFormat(pattern="dd/MM/yyyy")
	    private LocalDate birthDate;

	    @ManyToMany(cascade=CascadeType.ALL)
	    @JoinTable(name="user_has_cars", 
	    joinColumns= {@JoinColumn(name="id_user")},
	    inverseJoinColumns= {@JoinColumn(name="id_car")})
	    private List<CarDomain> cars;

		public Long getId() {
			return idUser;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public String getCpf() {
			return cpf;
		}

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public List<CarDomain> getCars() {
			return cars;
		}

		public void setCars(List<CarDomain> cars) {
			this.cars = cars;
		}
		

}
