package mvc.controller;

import Factory.FactoryLineaAerea;
import Factory.FactoryPasajeroFrecuente;
import dao.Interfaces.PasajeroFrecuenteDAO;
import dao.negocio.Aerolinea;
import dao.negocio.PasajeroFrecuente;

public class ControladorPasajeroFrecuente {
	
	PasajeroFrecuenteDAO pfDAO;
	ControladorLineaAerea contLA;
	
	public ControladorPasajeroFrecuente() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryPasajeroFrecuente();
		pfDAO = FactoryPasajeroFrecuente.getPasajeroFrecuenteDaoImplMysql();
		contLA = new ControladorLineaAerea();
	}
	
	public boolean altaPasajFrecuente(PasajeroFrecuente p) {
		return pfDAO.addPasajeroFrecuente(p);
	}
	
	public boolean bajaPasajFrecuente(String id) {
		return pfDAO.deletePasajeroFrecuente(id);
	}
	
	public boolean modPasajFrecuente(PasajeroFrecuente p) {
		return pfDAO.updatePasajeroFrecuente(p);
	}
	
	public PasajeroFrecuente consultarPasajeroFrecuente(String id) {
		PasajeroFrecuente pasajeroFrecuente = pfDAO.getPasajeroFrecuente(id);
		Aerolinea aerolinea = contLA.consultarLineaAerea(pasajeroFrecuente.getAerolinea().getId_aeroLinea().toString());
		
		pasajeroFrecuente.setAerolinea(aerolinea);
		
		return pasajeroFrecuente;
	}
	
	public PasajeroFrecuente obtenerUltimo() {
		return pfDAO.obtenerUltimo();
	}

}
