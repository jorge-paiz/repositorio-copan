package com.app.interfaz;

import java.util.List;

import com.app.modelo.Tipoempleado;

public interface CrudInterfaz {
	
	List<Tipoempleado> buscar();
	public void guardarTipoEmpleado(Tipoempleado tipemp);
	public void modificarTipoEmpleado(Tipoempleado tipemp);
	public void eliminarTipoEmpleado(Tipoempleado tipemp);

}
