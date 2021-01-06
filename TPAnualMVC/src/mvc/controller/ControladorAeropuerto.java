package mvc.controller;

import java.util.List;

import Factory.FactoryAeropuerto;
import dao.Interfaces.*;
import dao.negocio.*;

public class ControladorAeropuerto {
		
	AeropuertoDAO aeropDAO;

	public ControladorAeropuerto() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryAeropuerto();
		this.aeropDAO = FactoryAeropuerto.getAeropuertoDaoImplMysql();
	}
	
	public void altaAeropuerto(Aeropuerto a){
		aeropDAO.altaAeropuerto(a);
	}
	
	public void bajaAeropuerto(String id) {
		aeropDAO.bajaAeropuerto(id);
	}
	
	public Aeropuerto consultarAeropuerto(Integer id) {
		return aeropDAO.getAeropuerto(id);
	}
	
	public List<String> obtenerNombres(){
		return aeropDAO.obtenerCodigos();
	}
	
	public Aeropuerto consultaPorCodigo(String codigo) {
		return aeropDAO.consultaPorCodigo(codigo);
	}

}
