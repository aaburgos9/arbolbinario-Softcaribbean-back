package com.sofca.arbolBinBack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofca.arbolBinBack.Entity.Cliente;
import com.sofca.arbolBinBack.model.ArbolBinario;


@Service
public class ArbolBinarioService {


	@Autowired
	private IClienteService profesorService;
	
	private ArbolBinario arbolBinario;
	
	private void cargarArbol() {
		
		this.arbolBinario = new ArbolBinario();
		
		List<Cliente> clientes = profesorService.findAll();
		
		for (Cliente cliente : clientes) {
			
			this.arbolBinario.addNodo(cliente);
			
		}
		
	}
	
	public void addNodo(Cliente cliente) {
		
		this.cargarArbol();
		
		this.arbolBinario.addNodo(cliente);
		
	}
	
	public List<Cliente> getArbolBinarioInOrden(){
		
		this.cargarArbol();
		
		return this.arbolBinario.getDatosInOrden();
		
	}
	
	public List<Cliente> getArbolBinarioPreOrden(){
		
		this.cargarArbol();
		
		return this.arbolBinario.getDatosPreOrden();
		
	}
	
	public Cliente getNodo(String documento) {
		
		this.cargarArbol();
		
		return this.arbolBinario.getNodo(documento);
		
	}
	
	
	public boolean actualizarNodo(Cliente cliente) {
		
		this.cargarArbol();
		
		return this.arbolBinario.updateNodo(cliente);
		
	}
	
		
	
}
