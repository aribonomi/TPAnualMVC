package mvc.controller;

import Factory.FactoryPasaporte;
import dao.Interfaces.PasaporteDAO;
import dao.negocio.Pais;
import dao.negocio.Pasaporte;

public class ControladorPasaporte {
	
	PasaporteDAO pasaporteDAO;
	ControladorPais contPais;
	
	public ControladorPasaporte() {
		
	//Llamo a la implementación mediante el factory		
		new FactoryPasaporte();
		pasaporteDAO = FactoryPasaporte.getPasaporteDaoImplMysql();
		contPais = new ControladorPais();
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
		Pasaporte pasaporte = pasaporteDAO.getPasaporte(id);
		Pais pais = contPais.consultaPorID(pasaporte.getId_Pasaporte());
		
		pasaporte.setPaisEmision(pais);
		
		return pasaporte;
	}
	
	public Pasaporte obtenerUltimo() {
		return pasaporteDAO.obtenerUltimo();
	}
}
