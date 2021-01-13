package mvc.controller;

import Factory.FactoryPasajeroFrecuente;
import dao.Interfaces.PasajeroFrecuenteDAO;
import dao.negocio.PasajeroFrecuente;

public class ControladorPasajeroFrecuente {
	
	PasajeroFrecuenteDAO pfDAO;
	
	public ControladorPasajeroFrecuente() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryPasajeroFrecuente();
		pfDAO = FactoryPasajeroFrecuente.getPasajeroFrecuenteDaoImplMysql();
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
		return pfDAO.getPasajeroFrecuente(id);
	}
	
	public PasajeroFrecuente obtenerUltimo() {
		return pfDAO.obtenerUltimo();
	}

}
