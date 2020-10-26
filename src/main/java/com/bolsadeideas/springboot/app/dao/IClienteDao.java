package com.bolsadeideas.springboot.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.entities.Cliente;


public interface IClienteDao extends CrudRepository<Cliente, Long>{


}
