package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Factory.Factory;
import dao.Interfaces.AeropuertoDAO;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Aeropuerto;
import dao.negocio.Vuelo;
import mvc.view.VistaPrincipal;

public class ControladorVuelo{
	
	VuelosDAO vueloDAO;
	
	

	public ControladorVuelo(VistaPrincipal vista) {
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
	
	public Vuelo consultarVuelo(String id) {
		return vueloDAO.getVuelos(id);
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vista.agregarVuelo) {
			String numero = JOptionPane.showInputDialog(null, "N�mero de vuelo:");
			int cantidadAsientos = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de asientos: "));
			//private Aeropuerto aeropuertoLlegada;
			//private Aeropuerto aeropuertoSalida;
			String fechaLlegada = JOptionPane.showInputDialog(null, "Fecha de llegada (aaaa-mm-dd): ");
			String fechaSalida = JOptionPane.showInputDialog(null, "Fecha de salida (aaaa-mm-dd): ");;
			String tiempoVuelo = JOptionPane.showInputDialog(null, "Tiempo de vuelo: ");
		}else if(e.getSource()==this.vista.consultarVuelo) {
			
		}else if(e.getSource()==this.vista.eliminarVuelo) {
			
		}else if(e.getSource()==this.vista.modificarVuelo) {
			
		}
		
	}*/
	
	

}
