package mvc.controller;

import Factory.Factory;
import dao.Interfaces.TelefonoDAO;
import dao.negocio.Telefono;

public class ControladorTelefono {

	TelefonoDAO telefonoDAO;

	public ControladorTelefono() {
		new Factory();
		this.telefonoDAO = Factory.getTelefonoDaoImplMysql();
	}
	
	public void altaTelefono(Telefono t) {
		telefonoDAO.addTelefono(t);
	}
	
	public void bajaTelefono(String id) {
		telefonoDAO.deleteTelefono(id);
	}
	
	public void modTelefono(Telefono t) {
		telefonoDAO.updateTelefono(t);
	}
	
	public Telefono consultarTelefono(String id) {
		return telefonoDAO.getTelefono(id);
	}
	
}
