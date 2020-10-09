package com.app.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.configuracion.Conexion;

@ActiveProfiles("standalone")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Conexion.class})

public class Testeador {
	
	@Autowired
	Environment env;
	
//	@Autowired
//	@Qualifier("tipoempleadoS")
//	CrudInterfaz tps;
	
	@Test
	public void correr() {
//		testInicial();
		testConexion();
//		testTipoPersona();
		
	}
	
	public void testInicial() {
		System.out.println("inicio bien");
	}
	
	public void testConexion() {
		System.out.println(env.getRequiredProperty("aplicacion.test"));
	}
	
//	public void testTipoPersona() {
//		Tipoempleado tem = new Tipoempleado();
//		tem.setIdTipoEmpleado(3);
//		tem.setNombreTipoEmpleado("vendedora");
//		tps.eliminarTipoEmpleado(tem);
//		List<Tipoempleado> tipemps = tps.buscar();
//		for(Tipoempleado tipoempleado : tipemps) {
//			System.out.print(tipoempleado.getIdTipoEmpleado()+" ");
//			System.out.println(tipoempleado.getNombreTipoEmpleado());
//		}
		
		
//	}

}
