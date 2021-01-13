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
	
	public boolean altaPasaporte(Pasaporte p) {
		return pasaporteDAO.addPasaporte(p);
	}
	
	public boolean bajaPasaporte(String id) {
		return pasaporteDAO.deletePasaporte(id);
	}
	
	public boolean modPasaporte(Pasaporte p) {
		return pasaporteDAO.updatePasaporte(p);
	}
	
	public Pasaporte consultarPasaporte(String id) {
		return pasaporteDAO.getPasaporte(id);
	}
	
	public Pasaporte obtenerUltimo() {
		return pasaporteDAO.obtenerUltimo();
	}
}
