package mvc.controller;

import java.util.List;

import Factory.Factory;
import dao.Interfaces.ProvinciaDAO;
import dao.negocio.Provincia;

public class ControladorProvincia {
	
	ProvinciaDAO provDAO;
	
	public ControladorProvincia() {
		new Factory();
		provDAO = Factory.getProvinciaDaoImplMysql();
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
	

}
