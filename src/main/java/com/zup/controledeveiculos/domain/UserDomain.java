package com.zup.controledeveiculos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class UserDomain {
	
	@Id
	@Column
	private Long  id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String cpf ; 
	
	@Column
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
