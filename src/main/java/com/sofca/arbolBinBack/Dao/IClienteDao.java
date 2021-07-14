package com.sofca.arbolBinBack.Dao;

import org.springframework.data.repository.CrudRepository;

import com.sofca.arbolBinBack.Entity.Cliente;


public interface IClienteDao extends CrudRepository<Cliente, Long>{

	
	public Cliente findByDocumento(String documento);
	
}
