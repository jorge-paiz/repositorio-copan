package com.app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.interfaz.CrudInterfaz;
import com.app.modelo.Tipoempleado;

@Transactional
@Service("tipoempleadoS")
public class TipoempleadoS implements CrudInterfaz{
	
	@Autowired
	@Qualifier("tipoempleadoD")
	CrudInterfaz cri;

	@Override
	public List<Tipoempleado> buscar() {
		// TODO Auto-generated method stub
		return cri.buscar();
	}

	@Override
	public void guardarTipoEmpleado(Tipoempleado tipemp) {
		cri.guardarTipoEmpleado(tipemp);
		
	}

	@Override
	public void modificarTipoEmpleado(Tipoempleado tipemp) {
		cri.modificarTipoEmpleado(tipemp);
		
	}

	@Override
	public void eliminarTipoEmpleado(Tipoempleado tipemp) {
		cri.eliminarTipoEmpleado(tipemp);
		
	}

}
