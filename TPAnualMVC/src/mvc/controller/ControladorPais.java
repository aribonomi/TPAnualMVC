package mvc.controller;

import java.util.List;

import Factory.FactoryPais;
import dao.Interfaces.PaisDAO;
import dao.negocio.Pais;

public class ControladorPais {
	
	PaisDAO paisDAO;
	
	public ControladorPais() {
	
	//Llamo a la implementación mediante el factory	
		new FactoryPais();
		paisDAO = FactoryPais.getPaisDao();
	}
	
	public void altaPais(Pais p) {
		paisDAO.addPais(p);
	}
	
	public void bajaPais(String id) {
		paisDAO.deletePais(id);
	}
	
	public void modPais(Pais p) {
		paisDAO.updatePais(p);
	}
	
	public Pais consultarPais(String id) {
		return paisDAO.getPais(id);
	}
	
	public List<Pais> obtenerTodos(){
		return paisDAO.ListAllPais();
	}
	
	public List<String> obtenerNombres(){
		return paisDAO.obtenerNombres();
	}
	
	public Pais consultaPorID(Integer id) {
		return paisDAO.getPaisPorID(id);
	}

}
