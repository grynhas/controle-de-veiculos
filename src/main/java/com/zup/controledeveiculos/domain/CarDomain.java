package com.zup.controledeveiculos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cars")
public class CarDomain {
	
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_car")

	    private Long id;

	    @Column(nullable = false)
	    private String brand;

	    @Column(nullable = false)
	    private String model;

	    @Column(nullable = false)
	    private String year;

	    @Column(nullable = false)
	    private String value;

	    private String dayRotation;

	    private Boolean activeRotation = false;

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

		public void setDayRotation(String dayRotation) {
			this.dayRotation = dayRotation;
		}

		public void setActiveRotation(Boolean activeRotation) {
			this.activeRotation = activeRotation;
		}

		public void setValue(String value) {
			this.value = value;
		}



}
