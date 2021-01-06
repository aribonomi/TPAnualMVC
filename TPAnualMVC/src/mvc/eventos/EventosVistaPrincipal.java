package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mvc.view.*;

public class EventosVistaPrincipal implements ActionListener{
	
//Se llama a la vista principal	
	VistaPrincipal vistaP;

	public EventosVistaPrincipal(VistaPrincipal vistaP) {
		this.vistaP = vistaP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//Aparece la vista del cliente	
		if(e.getSource()==vistaP.mntmClientes) {
			VistaCliente vistaCliente = new VistaCliente();
			vistaCliente.setVisible(true);
			
	//Aparece la vista de la aerolínea	
		}else if(e.getSource()==vistaP.mntmAerolineas){
			VistaAerolinea vistaAerolinea = new VistaAerolinea();
			vistaAerolinea.setVisible(true);
			
	//Aparece la vista de las ventas		
		}else if(e.getSource()==vistaP.mntmVentas) {
			VistaVenta vistaVenta = new VistaVenta();
			vistaVenta.setVisible(true);
			
	//Aparece la vista de los vuelos		
		}else if(e.getSource()==vistaP.mntmVuelos){
			VistaVuelo vistaVuelo = new VistaVuelo();
			vistaVuelo.setVisible(true);
			
	//Finaliza la ejecución		
		}else if(e.getSource()==vistaP.mntmSalir) {
			int resultado = JOptionPane.showConfirmDialog(null, "Está seguro que quiere salir?", "Saliendo", JOptionPane.OK_CANCEL_OPTION);
			if(resultado == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
		
	}
	
	
	
	

}
