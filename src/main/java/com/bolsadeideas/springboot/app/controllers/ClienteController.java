package com.bolsadeideas.springboot.app.controllers;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.controllers.util.paginator.PageRender;
import com.bolsadeideas.springboot.app.entities.Cliente;
import com.bolsadeideas.springboot.app.services.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	private final static String UPLOADS_FOLDER = "uploads";

	@Autowired
	private IClienteService clienteService;

	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value="id")Long id,Model model,RedirectAttributes flash) {
	
		Cliente cliente = clienteService.findOne(id);
		if(cliente == null) {
			flash.addFlashAttribute("error", "El cliente que se intenta buscar no existe");
			return "redirect:/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Detalle del cliente: "+ cliente.getNombre());
		return "ver";
	}
	
	@GetMapping("/listar")
	public String listar(@RequestParam(name = "page",defaultValue = "0") int page, Model model) {

		
		Pageable pageRequest = PageRequest.of(page,4);
		
		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		PageRender<Cliente> pageRender = new PageRender<>(clientes, "/listar");
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@GetMapping("/form")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Formulario de cliente");
		return "form";
	}

	@PostMapping("/form")
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model,@RequestParam("file") MultipartFile foto,RedirectAttributes flash,SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente");
			return "form";
		}
		if(!foto.isEmpty()) {
			
			if(cliente.getId() != null 
					&& cliente.getFoto() != null
					&& cliente.getFoto().length() > 0) {
				
				Path rootPath = Paths.get(UPLOADS_FOLDER).resolve(cliente.getFoto()).toAbsolutePath();
				File archivo = rootPath.toFile();
				
				if(archivo.exists() && archivo.canRead()) {
					archivo.delete();
					
				}
				
			}
			String uniqueFileName = UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
			Path rootPath = Paths.get(UPLOADS_FOLDER).resolve(uniqueFileName);
			Path absolutePath = rootPath.toAbsolutePath();
			try {
				Files.copy(foto.getInputStream(), absolutePath);
				flash.addFlashAttribute("info", "La imagen se ha subido correctamente: " + uniqueFileName);
				
				cliente.setFoto(uniqueFileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String mensajeFlash = (cliente.getId() != null) ? "Cliente editado correctamente" : "Cliente creado correctamente";
		clienteService.save(cliente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}

	@GetMapping("/form/{id}")
	public String editarCliente(@PathVariable(value = "id") Long id, Model model,RedirectAttributes flash) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if(cliente == null) {
				flash.addFlashAttribute("error", "El cliente que se quiere editar no existe");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser 0");
			return "redirect:/listar";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar Cliente");

		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		if (id > 0) {
			Cliente cliente = clienteService.findOne(id);
			
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente eliminado correctamente");
			
			Path rootPath = Paths.get(UPLOADS_FOLDER).resolve(cliente.getFoto()).toAbsolutePath();
			File archivo = rootPath.toFile();
			
			if(archivo.exists() && archivo.canRead()) {
				if(archivo.delete()) {
					flash.addFlashAttribute("info", "Foto: "+cliente.getFoto() +" eliminada correctamente");
				}
			}
		}
		return "redirect:/listar";
	}

}
