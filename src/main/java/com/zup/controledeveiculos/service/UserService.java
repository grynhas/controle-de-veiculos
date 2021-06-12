package com.zup.controledeveiculos.service;

import org.springframework.stereotype.Service;

import com.zup.controledeveiculos.domain.UserDomain;
import com.zup.controledeveiculos.repository.UserRepository;

@Service
public class UserService {
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(UserDomain user) {
		userRepository.save(user);
	}
}
