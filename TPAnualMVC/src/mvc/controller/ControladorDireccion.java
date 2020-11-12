package mvc.controller;

import Factory.Factory;
import dao.Interfaces.DireccionDAO;
import dao.negocio.Direccion;

public class ControladorDireccion {
	
	DireccionDAO direccionDAO;
	
	public ControladorDireccion() {
		new Factory();
		direccionDAO = Factory.getDireccionDaoImplMysql();
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
	
}
