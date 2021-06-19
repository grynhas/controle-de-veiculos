package com.zup.controledeveiculos.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.controledeveiculos.domain.CarDomain;
import com.zup.controledeveiculos.repository.CarRepository;



@Service
public class CarService {
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	ApiService apiService;
	
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public CarDomain saveCar(CarDomain car) {
		String valor = apiService.buscarCarroNaFipe(car.getBrand(), car.getModel(), car.getYear()).getValor();
		car.setValue(valor);
		return carRepository.save(car);
	}
	
	public Optional<CarDomain> listCar(Long id) {
		return carRepository.findById(id);
	}
	
	public List<CarDomain> listAllCars() {
		return carRepository.findAll();
	}
	
	public CarDomain updateCarDomain(Long id, CarDomain car) {
		Optional<CarDomain> userOptional = carRepository.findById(id);
		return carRepository.save(car);
	}
	
	public void deleteCar(Long id) { 
		Optional<CarDomain> userOptional = carRepository.findById(id);
		
		if(!userOptional.isPresent()) 
			System.out.println("Usuário não existe");
		
		carRepository.deleteById(id);
	}
}

