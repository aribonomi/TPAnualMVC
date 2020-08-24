package mvc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class MenuPrincipal {
	
	public static void menuPrincipal() {
		
		miMarco marco1 = new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}



class miMarco extends JFrame{
	
	public miMarco() {
	
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamañopantalla = mipantalla.getScreenSize();
		int altura = tamañopantalla.height;
		int ancho = tamañopantalla.width;
		setBounds(500, 300, ancho/2, altura/2);

		JButton botonAbajo = new JButton("Alta de Cliente");
		this.add(botonAbajo, BorderLayout.NORTH);
		JButton botonAbajo2 = new JButton("Baja de Cliente");
		this.add(botonAbajo2, BorderLayout.CENTER);
		JButton botonAbajo3 = new JButton("Consulta de Cliente");
		this.add(botonAbajo3, BorderLayout.WEST);
		JButton botonAbajo4 = new JButton("Modificacion de Cliente");
		this.add(botonAbajo4, BorderLayout.SOUTH);
		
		
	}
	
}

class Lamina extends JPanel{

	
	
	
	
	
}