package com.bolsadeideas.springboot.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.entities.Cliente;

@Repository("clienteDaoImpl")
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {

		if (cliente.getId() != null && cliente.getId() > 0) {

			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	@Override
	public Cliente findOne(Long id) {

		return em.find(Cliente.class, id);
	}

	@Override
	public void delete(Long id) {

		em.remove(findOne(id));

	}

}
