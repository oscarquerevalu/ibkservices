package com.ibk.services.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the idusuario database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
})

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idusuario;

	private String nombre;

	private String apellido;

	private int edad;

	private String fecha_nacimiento;
	
	@Transient
	private String fecha_muerte;

	public Usuario() {
	}
	

	public Usuario(String nombre, String apellido, int edad, String fecha_nacimiento, String fecha_muerte) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_muerte = fecha_muerte;
	}


	public long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Transient
	public String getFecha_muerte() {
		return fecha_muerte;
	}


	public void setFecha_muerte(String fecha_muerte) {
		this.fecha_muerte = fecha_muerte;
	}

}