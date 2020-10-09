package com.app.configuracion;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.app")
@PropertySource(value = {"classpath:fuenteDeRecursos.properties"})
public class Conexion {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean contenedorLocal()throws NamingException{
		LocalContainerEntityManagerFactoryBean cl = new LocalContainerEntityManagerFactoryBean();
		cl.setDataSource(fuenteDeDatos());
		cl.setJpaProperties(propiedades());
		cl.setJpaVendorAdapter(vadaptador());
		cl.setPackagesToScan(new String[] {"com.app.modelo"}); 
		return cl;
	}
	
	public String obtener(String obtencion) {
		obtencion = env.getRequiredProperty(obtencion);
		return obtencion;
	}
	
	@Bean
	public DataSource fuenteDeDatos() {
		DriverManagerDataSource fd = new DriverManagerDataSource();
		fd.setDriverClassName(obtener("jdbc.driver"));
		fd.setUrl(obtener("jdbc.url"));
		fd.setUsername(obtener("jdbc.usuario"));
		fd.setPassword(obtener("jdbc.contrasenia"));
		return fd;
	}
	
	private Properties propiedades() {
		Properties pr = new Properties();
		pr.put("hibernate.dialecto", obtener("hibernate.dialecto"));
		pr.put("hibernate.mostrarSql", obtener("hibernate.mostrarSql"));
		pr.put("hibernate.formatoSql", obtener("hibernate.formatoSql"));
		return pr;
	}
	
	@Bean
	public JpaVendorAdapter vadaptador() {
		HibernateJpaVendorAdapter hadaptador = new HibernateJpaVendorAdapter();
		return hadaptador;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager plataformaTransaccional(EntityManagerFactory emf) {
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(emf);
		return jtm;
	}

}
