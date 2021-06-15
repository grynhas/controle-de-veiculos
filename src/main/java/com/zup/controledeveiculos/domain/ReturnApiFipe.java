package com.zup.controledeveiculos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class ReturnApiFipe {
	
	@Id
	@Column
	private Long  id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column (unique = true, nullable = false)
	private String email;
	
	@Column (unique = true, nullable = false)
	private String cpf; 
	
	@Column(nullable = false)
	private String dataDeNascimento;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

}
