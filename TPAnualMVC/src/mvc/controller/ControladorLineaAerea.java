package mvc.controller;

import java.util.List;

import Factory.FactoryLineaAerea;
import dao.Interfaces.LineaAereaDAO;
import dao.negocio.Aerolinea;

public class ControladorLineaAerea {
	
	public LineaAereaDAO lineaAereaDAO;
	
	
	public ControladorLineaAerea() {

	//Llamo a la implementación mediante el factory	
		new FactoryLineaAerea();
		lineaAereaDAO = FactoryLineaAerea.getLineaAereaDaoImplMysql();
	}
	
	public boolean altaLineaAerea(Aerolinea a) {
		return lineaAereaDAO.altaLineaAerea(a);
	}
	
	public boolean bajaLineaAerea(String id) {
		return lineaAereaDAO.bajaLineaAerea(id);
	}

	public boolean modLineaAerea(Aerolinea a) {
		return lineaAereaDAO.modificarLineaAerea(a);
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
