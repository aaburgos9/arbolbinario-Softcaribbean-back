package com.sofca.arbolBinBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofca.arbolBinBack.Entity.Cliente;

import com.sofca.arbolBinBack.Dao.IClienteDao;

@Service
public class ClienteServiceImpl implements IClienteService{

	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll(); 
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findCliente(Cliente cliente) {
		
		return clienteDao.findByDocumento(cliente.getDocumento()); 
		
	}

	@Override
	@Transactional
	public Cliente updateCliente(Cliente cliente) {
		
		return (Cliente) clienteDao.save(cliente);
		
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	

}
