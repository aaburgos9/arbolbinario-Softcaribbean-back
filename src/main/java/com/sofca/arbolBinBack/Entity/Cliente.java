package com.sofca.arbolBinBack.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tcus_clientes")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column (name="cus_nmcliente")
	private String documento;
	
	@Column (name="cus_dsnombres")
	private String nombre;
	
	@Column (name="cus_dsdireccion")
	private String direccion;
	
	@Column (name="cus_dscorreo")
	private String correo;
	

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String documento, String nombre, String direccion, String correo) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
	}

	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}	

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void add(Cliente cliente) {
		this.documento = cliente.getDocumento();
		this.nombre = cliente.getNombre();
		this.correo = cliente.getCorreo();
		this.direccion = cliente.getDireccion();
	}
	
	@Override
	public String toString() {
		return "Cliente [documento=" + documento + ", nombre=" + nombre + ", direccion=" + direccion + ", correo="
				+ correo + "]";
	}
	
	
	
	
	
}
