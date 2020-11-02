package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.Interfaces.LineaAereaDAO;
import mvc.view.VistaPrincipal;

public class ControladorLineaAerea implements ActionListener{
	
	public VistaPrincipal vista;
	public LineaAereaDAO lineaAereaDAO;
	
	
	public ControladorLineaAerea(VistaPrincipal vista) {

		this.vista = vista;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
	
	
	
	

}
