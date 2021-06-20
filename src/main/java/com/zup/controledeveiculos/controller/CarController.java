package com.zup.controledeveiculos.controller;

import java.net.URI;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.controledeveiculos.domain.CarDomain;
import com.zup.controledeveiculos.service.CarService;

@RestController
@RequestMapping("/cars")
@Validated
public class CarController {
	
	@Autowired
	private CarService carService; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CarDomain> add(@RequestBody CarDomain car){
		car.setDayRotation(defineDayRotation(car));
		CarDomain createCarDomain = carService.saveCar(car);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createCarDomain.getId())
				.toUri();
				
	
		return ResponseEntity.created(uri).body(createCarDomain);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Optional<CarDomain>> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(carService.listCar(id));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<CarDomain>> listAll() {
		return ResponseEntity.ok().body(carService.listAllCars());
	}
	
	@RequestMapping("/{id}")
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<CarDomain> updateUser(@RequestBody CarDomain user,@PathVariable Long id ) {
		return ResponseEntity.ok().body(carService.updateCarDomain(id, user));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		carService.deleteCar(id);
	}
	
	private String defineDayRotation(CarDomain car) {
		switch (car.getYear().substring(car.getYear().length() - 1)) {
		case "0":
		case "1":
			return DayOfWeek.MONDAY.toString();
		case "2":
		case "3":
			return DayOfWeek.THURSDAY.toString();
		case "4":
		case "5":
			return DayOfWeek.WEDNESDAY.toString();
		case "6":
		case "7":
			return DayOfWeek.THURSDAY.toString();
		case "8":
		case "9":
			return DayOfWeek.FRIDAY.toString();
		default:
			return "";
		}
	}
	
}
