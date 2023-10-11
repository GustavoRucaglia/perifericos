package com.itb.perifericos.perifericos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itb.perifericos.perifericos.model.Cliente;
import com.itb.perifericos.perifericos.repository.ClienteRepository;

@Controller
@RequestMapping("/perifericos")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	// paginas html
	@GetMapping("/carrinho")
	  public String carrinho() {
		
		return "carrinho";
	}
	
	@GetMapping("/login")
	  public String login() {
		
		return "login";
	}
	
	@GetMapping("/mouseprod")
	  public String mousepad() {
		
		return "mouse-prod";
	}
	
	@GetMapping("/cadastro")
	  public String novoCliente(Cliente cliente,Model model) {
		
		model.addAttribute("cliente",cliente);
		return "cadastro";
	}
	
	@GetMapping("/crud")
	  public String crud(Model model) {
		List<Cliente> listaclientes = clienteRepository.findAll(); 
		model.addAttribute("listaclientes",listaclientes);
		return "adm";
	}
	 
	@PutMapping("/desativar-usuario/{id}")
	public ResponseEntity<String> desativarUsuario(@PathVariable Long id) {
		clienteRepository.findById(id).ifPresent(usuario -> {
	        usuario.setCodStatusCliente(false);
	        clienteRepository.save(usuario);
	    });

	    return ResponseEntity.ok("Usuário desativado com sucesso");
	}
	
	@PutMapping("/ativar-usuario/{id}")
	public ResponseEntity<String> ativarUsuario(@PathVariable Long id) {
		clienteRepository.findById(id).ifPresent(usuario -> {
	        usuario.setCodStatusCliente(true);
	        clienteRepository.save(usuario);
	    });
		return ResponseEntity.ok("Usuário desativado com sucesso");
	}
	
	@GetMapping("/atendimento")
	  public String atendimento() {
		
		return "atendimento";
	}
	
	
	@GetMapping("/home")
	String home() {
		return "index.html";
	}
	
	//Cadastrar o cliente
	
	@PostMapping("/add-cliente")
	String addNovoCliente(Cliente cliente, Model model) {
		
		cliente.setCodStatusCliente(true);
		clienteRepository.save(cliente);
		
		return "redirect:/perifericos/crud";
	
	}	
    
	@GetMapping
	String showPageSucessoCadastro1() {
		return "home";
	}
	
	@GetMapping("/sucesso-cliente")
	String showPageSucessoCadastro() {
		return "perifericos/home";
	}
	
	
		
	}
	

