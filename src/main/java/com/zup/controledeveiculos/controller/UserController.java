package com.zup.controledeveiculos.controller;

import java.net.URI;
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
import com.zup.controledeveiculos.domain.UserDomain;
import com.zup.controledeveiculos.service.UserService;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	 public ResponseEntity<UserDomain> saveUser(@RequestBody UserDomain user) {
		UserDomain createUserDomain = userService.saveUser(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createUserDomain.getId())
				.toUri();
	
		return ResponseEntity.created(uri).body(createUserDomain);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Optional<UserDomain>> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(userService.listUser(id));
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UserDomain>> listAll() {
		return ResponseEntity.ok().body(userService.listAllUsers());
	}
	
	@RequestMapping("/{id}")
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UserDomain> updateUser(@RequestBody UserDomain user,@PathVariable Long id ) {
		return ResponseEntity.ok().body(userService.updateUserDomain(id, user));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PostMapping("{id}/cars")
	 public ResponseEntity<Void> saveUser(@PathVariable Long id, @RequestBody List<CarDomain> cars) {
		userService.comprarCarro(id, cars);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
