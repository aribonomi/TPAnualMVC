package mvc.controller;

import java.util.List;

import Factory.FactoryProvincia;
import dao.Interfaces.ProvinciaDAO;
import dao.negocio.Provincia;

public class ControladorProvincia {
	
	ProvinciaDAO provDAO;
	
	public ControladorProvincia() {
		
	//Llamo a la implementación mediante el factory
		new FactoryProvincia();
		provDAO = FactoryProvincia.getProvinciaDaoImplMysql();
	}
	
	public void altaProv(Provincia p) {
		provDAO.addProvincia(p);
	}
	
	public void bajaProv(String id) {
		provDAO.deleteProvincia(id);
	}
	
	public void modificarProv(Provincia p) {
		provDAO.updateProvincia(p);
	}
	
	public Provincia consultarProvincia(String id) {
		return provDAO.getProvincia(id);
	}
	
	public List<String> obtenerNombres() {
		return provDAO.obtenerNombres();
	}
	
	public Provincia consultarPorNombre(String nombre) {
		return provDAO.getProvinciaPorNombre(nombre);
	}
	

}
