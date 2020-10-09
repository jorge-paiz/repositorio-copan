package com.app.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.abstraccion.CrudAbstraccion;
import com.app.interfaz.CrudInterfaz;
import com.app.modelo.Tipoempleado;

@Component(value = "tipoempleadoD")
public class TipoempleadoD extends CrudAbstraccion<Integer, Tipoempleado> implements CrudInterfaz{

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipoempleado> buscar() {
		List<Tipoempleado> tiem = getEntityManager().createQuery("SELECT u FROM Tipoempleado u").getResultList();
		return tiem;
	}

	@Override
	public void guardarTipoEmpleado(Tipoempleado tipemp) {
		update(tipemp);
		
	}

	@Override
	public void modificarTipoEmpleado(Tipoempleado tipemp) {
		update(tipemp);
		
	}

	@Override
	public void eliminarTipoEmpleado(Tipoempleado tipemp) {
		delete(tipemp);
		
	}

}
