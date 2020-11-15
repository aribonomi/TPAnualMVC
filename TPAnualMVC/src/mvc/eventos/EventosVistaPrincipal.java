package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import mvc.view.VistaCliente;
import mvc.view.VistaPrincipal;

public class EventosVistaPrincipal implements ActionListener{
	
	VistaPrincipal vistaP;

	public EventosVistaPrincipal(VistaPrincipal vistaP) {
		this.vistaP = vistaP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vistaP.btnClientes) {
			VistaCliente vistaAgregarCliente = new VistaCliente();
			vistaAgregarCliente.setVisible(true);
		}if(e.getSource()==vistaP.btnSalir) {
			int resultado = JOptionPane.showConfirmDialog(null, "Está seguro que quiere salir?", "Saliendo", JOptionPane.OK_CANCEL_OPTION);
			if(resultado == JOptionPane.OK_OPTION) {
				System.exit(0);
			}else {
				
			}
		}
		
	}
	
	
	
	

}
