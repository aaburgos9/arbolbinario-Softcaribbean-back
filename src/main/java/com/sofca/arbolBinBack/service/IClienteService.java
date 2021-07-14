package com.sofca.arbolBinBack.service;

import java.util.List;

import com.sofca.arbolBinBack.Entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findCliente(Cliente cliente);
	
	public Cliente updateCliente(Cliente cliente);
	
	public Cliente save(Cliente cliente);
	
}
