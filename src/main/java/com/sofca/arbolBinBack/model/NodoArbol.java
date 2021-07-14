package com.sofca.arbolBinBack.model;

import com.sofca.arbolBinBack.Entity.Cliente;

public class NodoArbol {

	public Cliente dato;
	public NodoArbol hijoIzquierdo;
	public NodoArbol hijoDerecho;
	
	String nombre;
	
	public NodoArbol(Cliente cliente) {
		
		this.dato = cliente;
		
		this.hijoDerecho = null;
		this.hijoIzquierdo = null;
		
		
	}
	
}
