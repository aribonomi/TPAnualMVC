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


	public boolean altaVuelo(Vuelo v) {
		return vueloDAO.altaVuelo(v);
	}
	
	public boolean bajaVuelo(String id) {
		return vueloDAO.bajaVuelo(id);
	}
	
	public boolean modVuelo(Vuelo v) {
		return vueloDAO.modificarVuelo(v);
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
