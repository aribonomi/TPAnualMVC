package mvc.controller;

import java.util.List;

import Factory.FactoryAeropuerto;
import dao.Interfaces.*;
import dao.negocio.*;

public class ControladorAeropuerto {
		
	AeropuertoDAO aeropDAO;
	ControladorPais contPais;
	ControladorProvincia contProvincia;

	public ControladorAeropuerto() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryAeropuerto();
		this.aeropDAO = FactoryAeropuerto.getAeropuertoDaoImplMysql();
		contPais = new ControladorPais();
		contProvincia = new ControladorProvincia();
	}
	
	public boolean altaAeropuerto(Aeropuerto a){
		return aeropDAO.altaAeropuerto(a);
	}
	
	public boolean bajaAeropuerto(String id) {
		return aeropDAO.bajaAeropuerto(id);
	}
	
	public Aeropuerto consultarAeropuerto(Integer id) {
		Aeropuerto aeropuerto = aeropDAO.getAeropuerto(id);
		Pais pais = contPais.consultaPorID(aeropuerto.getPais().getId_pais());
		Provincia provincia = contProvincia.consultarProvincia(aeropuerto.getProvincia().getId_provincia().toString());
		
		aeropuerto.setPais(pais);
		aeropuerto.setProvincia(provincia);
		
		return aeropuerto;
	}
	
	public List<String> obtenerNombres(){
		return aeropDAO.obtenerCodigos();
	}
	
	public Aeropuerto consultaPorCodigo(String codigo) {
		return aeropDAO.consultaPorCodigo(codigo);
	}

}
