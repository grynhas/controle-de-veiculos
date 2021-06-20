package com.zup.controledeveiculos.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.controledeveiculos.domain.CarDomain;
import com.zup.controledeveiculos.domain.UserDomain;
import com.zup.controledeveiculos.repository.CarRepository;
import com.zup.controledeveiculos.repository.UserRepository;

import antlr.Utils;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CarRepository carRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDomain saveUser(UserDomain user) {
		return userRepository.save(user);
	}
	
	public Optional<UserDomain> listUser(Long id) {
		Optional<UserDomain> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()) 
			return Optional.empty();
		UserDomain usuario = userOptional.get();
		List<CarDomain> cars = usuario.getCars(); 
		for (CarDomain carDomain : cars) {
			carDomain.setActiveRotation(isRotationActive(carDomain));
		}
		usuario.setCars(cars);
		System.out.println(cars);
		return Optional.of(usuario);
	}
	
	public List<UserDomain> listAllUsers() {
		return userRepository.findAll();
	}
	
	public UserDomain updateUserDomain(Long id, UserDomain user) {
		Optional<UserDomain> userOptional = userRepository.findById(id);
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) { 
		Optional<UserDomain> userOptional = userRepository.findById(id);
		userRepository.deleteById(id);
	}
	
	public void comprarCarro(Long userId, Long carId) {
		Optional<UserDomain> userOptional = userRepository.findById(userId);
		Optional<CarDomain> carOptional = carRepository.findById(carId);
		
		if(!userOptional.isPresent() && !carOptional.isPresent()) 
			System.out.println("Esse usuário não existe, tá me tirando?");
		
		UserDomain usuario = userOptional.get();
		CarDomain car = carOptional.get();
		List<CarDomain> cars = usuario.getCars();
		cars.add(car);
		usuario.setCars(cars);
		
		userRepository.saveAndFlush(usuario);
	}
	private boolean isRotationActive(CarDomain car) {
		System.out.println(LocalDateTime.now().getDayOfWeek().toString());
		System.out.println(car.getDayRotation());
		System.out.println(car.getDayRotation().equals(LocalDateTime.now().getDayOfWeek().toString()));
		
		return car.getDayRotation().equals(LocalDateTime.now().getDayOfWeek().toString());
	}
}

