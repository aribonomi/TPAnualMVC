package mvc.controller;

import Factory.FactoryDireccion;
import dao.Interfaces.DireccionDAO;
import dao.negocio.Direccion;

public class ControladorDireccion {
	
	DireccionDAO direccionDAO;
	
	public ControladorDireccion() {
		
	//Llamo a la implementación mediante el factory
		new FactoryDireccion();
		direccionDAO = FactoryDireccion.getDireccionDaoImplMysql();
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
		return direccionDAO.getDireccion(id);
	}
	
	public Direccion obtenerUltimo() {
		return direccionDAO.obtenerUltimo();
	}
	
	
}
