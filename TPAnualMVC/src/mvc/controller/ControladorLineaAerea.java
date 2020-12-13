package mvc.controller;

import java.util.List;

import Factory.Factory;
import dao.Interfaces.LineaAereaDAO;
import dao.negocio.Aerolinea;

public class ControladorLineaAerea {
	
	public LineaAereaDAO lineaAereaDAO;
	
	
	public ControladorLineaAerea() {

	//Llamo a la implementación mediante el factory	
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
	
	public Aerolinea consultaPorNombre(String nombre) {
		return lineaAereaDAO.consultarPorNombre(nombre);
	}
	
	public List<String> obtenerNombres(){
		return lineaAereaDAO.obtenerNombres();
	}
	
	
	
	
	
	

}
