package mvc.controller;

import Factory.FactoryDireccion;
import dao.Interfaces.DireccionDAO;
import dao.negocio.Direccion;
import dao.negocio.Pais;
import dao.negocio.Provincia;

public class ControladorDireccion {
	
	DireccionDAO direccionDAO;
	ControladorPais contPais;
	ControladorProvincia contProvincia;
	
	public ControladorDireccion() {
		
	//Llamo a la implementación mediante el factory
		new FactoryDireccion();
		direccionDAO = FactoryDireccion.getDireccionDaoImplMysql();
		contPais = new ControladorPais();
		contProvincia = new ControladorProvincia();
	}

	
	public boolean altaDireccion(Direccion d) {
		return direccionDAO.altaDireccion(d);
	}
	
	public boolean bajaDireccion(String id) {
		return direccionDAO.bajaDireccion(id);
	}
	
	public boolean modDireccion(Direccion d) {
		return direccionDAO.modificacionDireccion(d);
	}
	
	public Direccion consultar(String id) {
		Direccion direccion = direccionDAO.getDireccion(id);
		Pais p = contPais.consultaPorID(direccion.getPais().getId_pais());
		Provincia provincia = contProvincia.consultarProvincia(direccion.getProvincia().getId_provincia().toString());
		
		direccion.setPais(p);
		direccion.setProvincia(provincia);
		
		return direccion;
	}
	
	public Direccion obtenerUltimo() {
		return direccionDAO.obtenerUltimo();
	}
	
	
}
