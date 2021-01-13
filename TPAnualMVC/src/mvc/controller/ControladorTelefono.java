package mvc.controller;

import Factory.FactoryTelefono;
import dao.Interfaces.TelefonoDAO;
import dao.negocio.Telefono;

public class ControladorTelefono {

	TelefonoDAO telefonoDAO;

	public ControladorTelefono() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryTelefono();
		this.telefonoDAO = FactoryTelefono.getTelefonoDaoImplMysql();
	}
	
	public boolean altaTelefono(Telefono t) {
		return telefonoDAO.addTelefono(t);
	}
	
	public boolean bajaTelefono(String id) {
		return telefonoDAO.deleteTelefono(id);
	}
	
	public boolean modTelefono(Telefono t) {
		return telefonoDAO.updateTelefono(t);
	}
	
	public Telefono consultarTelefono(String id) {
		return telefonoDAO.getTelefono(id);
	}
	
	public Telefono obtenerUltimo() {
		return telefonoDAO.obtenerUltimo();
	}
	
}
