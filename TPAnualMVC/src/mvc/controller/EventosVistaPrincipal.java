package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.VistaCliente;
import mvc.view.VistaPrincipal;

public class EventosVistaPrincipal implements ActionListener{
	
	VistaPrincipal vistaP;

	public EventosVistaPrincipal(VistaPrincipal vistaP) {
		this.vistaP = vistaP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vistaP.agregarCliente) {
			VistaCliente vistaAgregarCliente = new VistaCliente();
			vistaAgregarCliente.setVisible(true);
		}
		
	}
	
	
	
	

}
