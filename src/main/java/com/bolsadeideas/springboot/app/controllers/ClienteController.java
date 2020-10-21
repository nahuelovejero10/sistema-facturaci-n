package com.bolsadeideas.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.app.dao.IClienteDao;
import com.bolsadeideas.springboot.app.entities.Cliente;

@Controller
public class ClienteController {

	@Autowired
	@Qualifier("clienteDaoImpl")
	private IClienteDao clienteDao;

	@GetMapping("/listar")
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listar";
	}

	@GetMapping("/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Formulario de cliente");
		return"form";
	}
	
	
	@PostMapping("/form")
	public String guardar(Cliente cliente) {
		
		clienteDao.save(cliente);
		return "redirect:listar";
	}
	
}
