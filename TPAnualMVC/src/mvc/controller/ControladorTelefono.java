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
	
	public Telefono obtenerUltimo() {
		return telefonoDAO.obtenerUltimo();
	}
	
}
