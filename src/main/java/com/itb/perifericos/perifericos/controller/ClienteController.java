package com.itb.perifericos.perifericos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itb.perifericos.perifericos.model.Cliente;
import com.itb.perifericos.perifericos.repository.ClienteRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/perifericos")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/novo-cliente")
	  public String novoCliente(Cliente cliente,Model model) {
		
		model.addAttribute("cliente",cliente);
		return "cadastro";
	}
	
	
	//Cadastrar o cliente
	
	@PostMapping("/add-cliente")
	String addNovoCliente(Cliente cliente, Model model) {
		
		cliente.setCodStatusCliente(true);
		clienteRepository.save(cliente);
		
		return "redirect:/perifericos/cliente/home";
	
	}	
    
	@GetMapping
	String showPageSucessoCadastro1() {
		return "home";
	}
	
	@GetMapping("/sucesso-cliente")
	String showPageSucessoCadastro() {
		return "perifericos/home";
	}
	
	@GetMapping("/novo-cliente")
	  public String novoCliente() {
		
		return "cadastro";
	}
	
	@GetMapping("/novo-cliente")
	  public String novoCliente() {
		
		return "cadastro";
	}
		
	}
	

