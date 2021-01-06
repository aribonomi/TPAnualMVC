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

	
	public void altaDireccion(Direccion d) {
		direccionDAO.altaDireccion(d);
	}
	
	public void bajaDireccion(String id) {
		direccionDAO.bajaDireccion(id);
	}
	
	public void modDireccion(Direccion d) {
		direccionDAO.modificacionDireccion(d);
	}
	
	public Direccion consultar(String id) {
		return direccionDAO.getDireccion(id);
	}
	
	public Direccion obtenerUltimo() {
		return direccionDAO.obtenerUltimo();
	}
	
	
}
