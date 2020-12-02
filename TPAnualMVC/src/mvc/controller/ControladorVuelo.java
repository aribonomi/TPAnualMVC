package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import Factory.Factory;
import dao.Interfaces.AeropuertoDAO;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Aeropuerto;
import dao.negocio.Vuelo;
import mvc.view.VistaPrincipal;

public class ControladorVuelo{
	
	VuelosDAO vueloDAO;
	
	

	public ControladorVuelo() {
		new Factory();
		vueloDAO = Factory.getVuelosDaoImplMysql();
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
