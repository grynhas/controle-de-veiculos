package com.zup.controledeveiculos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "cars")
public class CarDomain {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_cars")
	    private Long id;

	    @Column(nullable = false)
	    private String brand;

	    @Column(nullable = false)
	    private String model;

	    @Column(nullable = false)
	    private String year;

	    @Column(nullable = false)
	    private String value;

	    @Column
	    private String dayRotation;

	    @Column
	    private Boolean activeRotation = false;

	    @ManyToOne
	    @JoinColumn (name = "id_users", nullable = false)
	    @JsonBackReference
	    private UserDomain users;

		public Long getId() {
			return id;
		}

		public String getBrand() {
			return brand;
		}

		public String getModel() {
			return model;
		}

		public String getYear() {
			return year;
		}

		public String getValue() {
			return value;
		}

		public String getDayRotation() {
			return dayRotation;
		}

		public Boolean getActiveRotation() {
			return activeRotation;
		}

		public UserDomain getUsers() {
			return users;
		}
	

}
