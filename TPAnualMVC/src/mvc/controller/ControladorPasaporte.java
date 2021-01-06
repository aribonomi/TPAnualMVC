package mvc.controller;

import Factory.FactoryPasaporte;
import dao.Interfaces.PasaporteDAO;
import dao.negocio.Pasaporte;

public class ControladorPasaporte {
	
	PasaporteDAO pasaporteDAO;
	
	public ControladorPasaporte() {
		
	//Llamo a la implementación mediante el factory		
		new FactoryPasaporte();
		pasaporteDAO = FactoryPasaporte.getPasaporteDaoImplMysql();
	}
	
	public void altaPasaporte(Pasaporte p) {
		pasaporteDAO.addPasaporte(p);
	}
	
	public void bajaPasaporte(String id) {
		pasaporteDAO.deletePasaporte(id);
	}
	
	public void modPasaporte(Pasaporte p) {
		pasaporteDAO.updatePasaporte(p);
	}
	
	public Pasaporte consultarPasaporte(String id) {
		return pasaporteDAO.getPasaporte(id);
	}
	
	public Pasaporte obtenerUltimo() {
		return pasaporteDAO.obtenerUltimo();
	}
}
