package mvc.controller;

import java.util.List;
import Factory.FactoryVuelo;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Vuelo;

public class ControladorVuelo{
	
	VuelosDAO vueloDAO;
	
	

	public ControladorVuelo() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryVuelo();
		vueloDAO = FactoryVuelo.getVuelosDaoImplMysql();
	}


	public void altaVuelo(Vuelo v) {
		vueloDAO.altaVuelo(v);
	}
	
	public void bajaVuelo(String id) {
		vueloDAO.bajaVuelo(id);
	}
	
	public void modVuelo(Vuelo v) {
		vueloDAO.modificarVuelo(v);
	}
	
	public Vuelo consultarVuelo(Integer id) {
		return vueloDAO.getVuelos(id);
	}
	
	public List<Integer> obtenerIds(){
		return vueloDAO.obtenerIDs();
	}
	
	public Vuelo obtenerUltimo() {
		return vueloDAO.obtenerUltimo();
	}
	public Integer obtenerUltimoId() {
		return vueloDAO.obtenerUltimo().getId_Vuelo();
	}
	

}
