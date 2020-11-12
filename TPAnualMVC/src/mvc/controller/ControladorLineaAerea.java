package mvc.controller;

import Factory.Factory;
import dao.Interfaces.LineaAereaDAO;
import dao.negocio.Aerolinea;

public class ControladorLineaAerea {
	
	public LineaAereaDAO lineaAereaDAO;
	
	
	public ControladorLineaAerea() {

		new Factory();
		lineaAereaDAO = Factory.getLineaAereaDaoImplMysql();
	}
	
	public void altaLineaAerea(Aerolinea a) {
		lineaAereaDAO.altaLineaAerea(a);
	}
	
	public void bajaLineaAerea(String id) {
		lineaAereaDAO.bajaLineaAerea(id);
	}

	public void modLineaAerea(Aerolinea a) {
		lineaAereaDAO.modificarLineaAerea(a);
	}
	
	public Aerolinea consultarLineaAerea(String id) {
		return lineaAereaDAO.getLineaArea(id);
	}
	
	
	
	
	
	

}
