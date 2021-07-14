package com.sofca.arbolBinBack.model;

import java.util.ArrayList;
import java.util.List;

import com.sofca.arbolBinBack.Entity.Cliente;

public class ArbolBinario {

	
	public NodoArbol raiz;
	
	public List<Cliente>datos;
	
	
	public ArbolBinario() {
		
		this.raiz = null;
		
	}
	
	public void addNodo(Cliente dato) {
		
		NodoArbol newNodo = new NodoArbol(dato);
		
		if(this.raiz == null) {
			this.raiz = newNodo;
			return ;
		}
		
		
		NodoArbol nodoAux = this.raiz;
		NodoArbol padre;
		
		while(true) {
			
			padre = nodoAux;
			
			if(Integer.parseInt(dato.getDocumento()) <= Integer.parseInt(nodoAux.dato.getDocumento())) {
				
				nodoAux = nodoAux.hijoIzquierdo;
				
				if(nodoAux == null) {
					padre.hijoIzquierdo = newNodo;
					return ;
				}
				
			}else {
				nodoAux = nodoAux.hijoDerecho;
				
				if(nodoAux == null) {
					padre.hijoDerecho = newNodo;
					return ;
				}
			}
			
		}
		
		
	}
	
	public boolean estaVacio() {
		return this.raiz == null;
	}
	
	public List<Cliente> getDatosInOrden(){
		
		this.datos = new ArrayList<Cliente>();
		
		this.inOrden(this.raiz);
		
		return this.datos;
		
	}
	
	public List<Cliente> getDatosPreOrden(){
		
		this.datos = new ArrayList<Cliente>();
		
		this.preOrden(this.raiz);
		
		return this.datos;
		
	}
	
	private void inOrden(NodoArbol raiz) {
		
		if(raiz == null) {
			return ;
		}
		
		
		inOrden(raiz.hijoIzquierdo);
		this.datos.add(raiz.dato);
		inOrden(raiz.hijoDerecho);
		
	}
	
	public void preOrden(NodoArbol raiz) {
		
		if(raiz == null) {
			return ;
		}
		
		
		this.datos.add(raiz.dato);
		preOrden(raiz.hijoIzquierdo);		
		preOrden(raiz.hijoDerecho);
		
	}
		
	public Cliente getNodo(String dato) {
			
		if(raiz == null) {
			return null;
		}
		
		NodoArbol aux = this.raiz;
		
		while(aux.dato.getDocumento().equals(dato) == false) {
			
			if(Integer.parseInt(dato) < Integer.parseInt(aux.dato.getDocumento())) {
				aux = aux.hijoIzquierdo;
			}else {
				aux = aux.hijoDerecho;
			}
			
			if(aux == null) {
				return null;
			}
			
		}
		
		
		return aux.dato;
		
		
	}
	
	public boolean updateNodo(Cliente cliente) {
		
		if(raiz == null) {
			return false;
		}
		
		NodoArbol aux = this.raiz;
		
		while(aux.dato.getDocumento().equals(cliente.getDocumento()) == false) {
			
			if(Integer.parseInt(cliente.getDocumento()) < Integer.parseInt(aux.dato.getDocumento())) {
				aux = aux.hijoIzquierdo;
			}else {
				aux = aux.hijoDerecho;
			}
			
			if(aux == null) {
				return false;
			}
			
		}
		
		
		aux.dato = cliente;
		
		return true;
		
		
	}
		
//		public boolean eliminar(int dato) {
//			
//			if(raiz == null) {
//				return false;
//			}
//			
//			NodoArbol aux = this.raiz;
//			NodoArbol padre = this.raiz;
//			
//			boolean esIzq = true;
//			
//			while(aux.dato.getId() != dato) {
//				
//				padre = aux;
//				
//				if(dato < aux.dato.getId()) {
//					aux = aux.hijoIzquierdo;
//					esIzq = true;
//				}else {
//					aux = aux.hijoDerecho;
//					esIzq = false;
//				}
//				
//				if(aux == null) {
//					return false;
//				}
//				
//			}
//			
//			
//			// encontrado
//			
//			//si es hoja
//			if(aux.hijoIzquierdo == null && aux.hijoDerecho == null ) {
//				
//				if(aux == this.raiz) {// si esa hoja es la raiz
//					this.raiz = null;
//				}else if(esIzq){
//					padre.hijoIzquierdo =null;
//				}else {
//					padre.hijoDerecho = null;
//				}
//				
//				
//			}else if(aux.hijoDerecho == null) {
//				
//				if(aux == this.raiz) {
//					this.raiz = aux.hijoIzquierdo;
//				}else if(esIzq){
//					padre.hijoIzquierdo = aux.hijoIzquierdo;
//				}else {
//					padre.hijoDerecho = aux.hijoIzquierdo;
//				}
//				
//			}else if(aux.hijoIzquierdo == null) {
//				
//				if(aux == this.raiz) {
//					this.raiz = aux.hijoDerecho;
//				}else if(esIzq){
//					padre.hijoIzquierdo = aux.hijoDerecho;
//				}else {
//					padre.hijoDerecho = aux.hijoDerecho;
//				}
//				
//			}else{
//				
//				NodoArbol reemplazo = this.obtenerNodoReemplazo(aux);
//				
//				if(aux == this.raiz) {
//					this.raiz = reemplazo;
//				}else if(esIzq) {
//					padre.hijoIzquierdo = reemplazo;
//				}else {
//					padre.hijoDerecho = reemplazo;
//				}
//				
//				reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
//				
//			}
//			
//			
//			return true;
//			
//		}
		
		
		
		public NodoArbol obtenerNodoReemplazo(NodoArbol nodoR) {
			
			NodoArbol  reemplazarPadre = nodoR;
			
			NodoArbol  reemplazo = nodoR;
			
			NodoArbol aux = nodoR.hijoDerecho;
			
			while(aux != null) {
				
				reemplazarPadre = reemplazo;
				
				reemplazo = aux;
				
				aux = aux.hijoIzquierdo;
				
				
			}
			
			if(reemplazo != nodoR.hijoDerecho) {
				
				reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
				
				reemplazo.hijoDerecho = nodoR.hijoDerecho;
			}
			
			System.out.println("El nodo R es " + reemplazo.toString());
			
			return reemplazo;
			
		}


		@Override
		public String toString() {
			return "ArbolBinario [raiz=" + raiz.dato.getNombre() + "]";
		}
		
		
		
	
	
}
