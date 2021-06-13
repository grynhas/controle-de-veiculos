package com.zup.controledeveiculos.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.controledeveiculos.domain.UserDomain;
import com.zup.controledeveiculos.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDomain saveUser(UserDomain user) {
		return userRepository.save(user);
	}
	
	public Optional<UserDomain> listUser(Long id) {
		return userRepository.findById(id);
	}
	
	public List<UserDomain> listAllUsers() {
		return userRepository.findAll();
	}
	
	public UserDomain updateUserDomain(Long id, UserDomain user) {
		
		Optional<UserDomain> userOptional = userRepository.findById(id);
		
		return userRepository.save(user);
		
	}
}

