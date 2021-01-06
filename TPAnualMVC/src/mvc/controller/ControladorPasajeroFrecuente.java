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
	
	public void altaPasajFrecuente(PasajeroFrecuente p) {
		pfDAO.addPasajeroFrecuente(p);
	}
	
	public void bajaPasajFrecuente(String id) {
		pfDAO.deletePasajeroFrecuente(id);
	}
	
	public void modPasajFrecuente(PasajeroFrecuente p) {
		pfDAO.updatePasajeroFrecuente(p);
	}
	
	public PasajeroFrecuente consultarPasajeroFrecuente(String id) {
		return pfDAO.getPasajeroFrecuente(id);
	}
	
	public PasajeroFrecuente obtenerUltimo() {
		return pfDAO.obtenerUltimo();
	}

}
