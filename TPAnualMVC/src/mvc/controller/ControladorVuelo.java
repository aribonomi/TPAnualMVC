package mvc.controller;

import java.util.List;
import Factory.FactoryVuelo;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Aerolinea;
import dao.negocio.Aeropuerto;
import dao.negocio.Vuelo;

public class ControladorVuelo{
	
	VuelosDAO vueloDAO;
	ControladorAeropuerto contAeropuerto;
	ControladorLineaAerea contLA;
	
	

	public ControladorVuelo() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryVuelo();
		vueloDAO = FactoryVuelo.getVuelosDaoImplMysql();
		contAeropuerto = new ControladorAeropuerto();
		contLA = new ControladorLineaAerea();
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
		Vuelo vuelo = vueloDAO.getVuelos(id);
		Aeropuerto aeropSalida = contAeropuerto.consultarAeropuerto(vuelo.getAeropuertoSalida().getId_Aeropuerto());
		Aeropuerto aeropLlegada = contAeropuerto.consultarAeropuerto(vuelo.getAeropuertoLlegada().getId_Aeropuerto());
		Aerolinea aerolinea = contLA.consultarLineaAerea(vuelo.getAerolinea().getId_aeroLinea().toString());
		
		vuelo.setAeropuertoSalida(aeropSalida);
		vuelo.setAeropuertoLlegada(aeropLlegada);
		vuelo.setAerolinea(aerolinea);
		
		return vuelo; 
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
