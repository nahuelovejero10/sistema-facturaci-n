package com.bolsadeideas.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.app.dao.IClienteDao;
import com.bolsadeideas.springboot.app.entities.Cliente;

@Controller
@SessionAttributes("cliente")
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
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
		model.addAttribute("titulo", "Formulario de cliente");
		return "form";	
		}
		clienteDao.save(cliente);
		status.setComplete();
		return "redirect:listar";
	}
	
	
	@GetMapping("/form/{id}")
	public String editarCliente(@PathVariable(value = "id") Long id, Model model) {
	
		Cliente cliente = null;
		
		if(id > 0) {
			cliente = clienteDao.findOne(id);
		}else {
			return "redirect:/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar Cliente");
		
		return "form";
	}
}
