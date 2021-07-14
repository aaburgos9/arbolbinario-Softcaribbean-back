package com.sofca.arbolBinBack.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sofca.arbolBinBack.Entity.Cliente;
import com.sofca.arbolBinBack.service.ArbolBinarioService;
import com.sofca.arbolBinBack.service.IClienteService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private ArbolBinarioService arbolBinarioService;
	
	@GetMapping("/arbol_inorden")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> getArbolInOrden(){
		
		return arbolBinarioService.getArbolBinarioInOrden();
		
	}
	
	@GetMapping("/arbol_preorden")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> getArbolPreOrden(){
		
		return arbolBinarioService.getArbolBinarioPreOrden();
		
	}
	
	
	
	@GetMapping("/nodo_by_documento/{documento}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente getNodoByDocumento(@PathVariable(value="documento") String documento){
		
		return arbolBinarioService.getNodo(documento);
		
	}
	
	@PostMapping("/add_nodo")
	public ResponseEntity<Cliente> postAddNodo(@RequestBody Cliente cliente){
		
		Cliente newCliente = new Cliente();
		
		
		if(clienteService.findCliente(cliente) == null) {
			
			arbolBinarioService.addNodo(cliente);
			
			newCliente = clienteService.save(cliente);
			return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Cliente>(newCliente, HttpStatus.BAD_REQUEST);
		
		
	}
	
	@PutMapping("/edit_nodo/{documento}")
	public ResponseEntity<Cliente> putEditNodo(@PathVariable(value="documento") String documento, @RequestBody Cliente cliente){
		
		Cliente nodoArbol = arbolBinarioService.getNodo(documento);
		
		if(nodoArbol != null) {
			
//			nodoArbol.setDocumento(cliente.getDocumento());
//			nodoArbol.setNombre(cliente.getNombre());
//			nodoArbol.setCorreo(cliente.getCorreo());
//			nodoArbol.setDireccion(cliente.getDireccion());
			
			arbolBinarioService.actualizarNodo(cliente);
			
			
			Cliente oldCliente = clienteService.findCliente(cliente);
			
			if(oldCliente != null) {
				
				oldCliente.add(cliente);
				
				oldCliente = clienteService.updateCliente(oldCliente);
				
				return new ResponseEntity<Cliente>(oldCliente, HttpStatus.OK);
				
			}
		}
		
		
		
		return new ResponseEntity<Cliente>(nodoArbol, HttpStatus.BAD_REQUEST);		
		
		
	} 
	
	
	
}
