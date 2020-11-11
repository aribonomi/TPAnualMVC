package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.view.VistaAgregarCliente;
import mvc.view.VistaPrincipal;

public class EventosVistaPrincipal implements ActionListener{
	
	VistaPrincipal vistaP;

	public EventosVistaPrincipal(VistaPrincipal vistaP) {
		this.vistaP = vistaP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vistaP.agregarCliente) {
			VistaAgregarCliente vistaAgregarCliente = new VistaAgregarCliente();
			vistaAgregarCliente.setVisible(true);
		}
		
	}
	
	
	
	

}
