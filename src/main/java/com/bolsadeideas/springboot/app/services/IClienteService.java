package com.bolsadeideas.springboot.app.services;

import java.util.List;

import com.bolsadeideas.springboot.app.entities.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void delete(Long id);
}
