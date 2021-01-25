package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mvc.view.*;

public class EventosVistaPrincipal implements ActionListener{
	
//Se llama a la vista principal	
	VistaPrincipal2 vistaP;

	public EventosVistaPrincipal(VistaPrincipal2 vistaP) {
		this.vistaP = vistaP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//Aparece la vista del cliente	
		if(e.getSource()==vistaP.mntmClientes) {
			VistaCliente2 vistaCliente = new VistaCliente2();
			vistaCliente.setVisible(true);
			
	//Aparece la vista de la aerolínea	
		}else if(e.getSource()==vistaP.mntmAerolineas){
			VistaAerolinea2 vistaAerolinea = new VistaAerolinea2();
			vistaAerolinea.setVisible(true);
			
	//Aparece la vista de las ventas		
		}else if(e.getSource()==vistaP.mntmVentas) {
			VistaVenta2 vistaVenta = new VistaVenta2();
			vistaVenta.setVisible(true);
			
	//Aparece la vista de los vuelos		
		}else if(e.getSource()==vistaP.mntmVuelos){
			VistaVuelo2 vistaVuelo = new VistaVuelo2();
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
