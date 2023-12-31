package com.itb.perifericos.perifericos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private String endereco;
	private Boolean codStatusCliente = true;
	
	public Cliente() {
		
	}
	
	
	
	public Cliente(Long id, String nome, String email, String cpf, String senha, String endereco,
			Boolean codStatusCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
		this.codStatusCliente = codStatusCliente;
	}



	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean isCodStatusCliente() {
		return codStatusCliente;
	}

	public void setCodStatusCliente(boolean codStatusCliente) {
		this.codStatusCliente = codStatusCliente;
	}
	

	
}
