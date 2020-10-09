package com.app.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tipoempleado", uniqueConstraints = 
			{@UniqueConstraint
					(columnNames =
						{"idTipoEmpleado"}
					)
			})
public class Tipoempleado implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int idTipoEmpleado;
	
	@Column(nullable = false)
	private String nombreTipoEmpleado;

	public int getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(int idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getNombreTipoEmpleado() {
		return nombreTipoEmpleado;
	}

	public void setNombreTipoEmpleado(String nombreTipoEmpleado) {
		this.nombreTipoEmpleado = nombreTipoEmpleado;
	}
	
	

}
