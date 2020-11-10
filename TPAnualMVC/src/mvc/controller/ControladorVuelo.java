package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Factory.Factory;
import dao.Interfaces.AeropuertoDAO;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Aeropuerto;
import mvc.view.VistaPrincipal;

public class ControladorVuelo implements ActionListener{
	
	VistaPrincipal vista;
	VuelosDAO vueloDAO;
	AeropuertoDAO aeropDAO;
	
	
	

	public ControladorVuelo(VistaPrincipal vista) {
		this.vista = vista;
		vueloDAO = new Factory().getVuelosDaoImplMysql();
		aeropDAO = new Factory().getAeropuertoDaoImplMysql();
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vista.agregarVuelo) {
			String numero = JOptionPane.showInputDialog(null, "Número de vuelo:");
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
		
	}
	
	

}
