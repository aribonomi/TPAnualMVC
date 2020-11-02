package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Factory.Factory;
import dao.Interfaces.ClienteDAO;
import dao.Interfaces.DireccionDAO;
import dao.Interfaces.TelefonoDAO;
import dao.negocio.Aerolinea;
import dao.negocio.Alianza;
import dao.negocio.Direccion;
import dao.negocio.Pais;
import dao.negocio.Provincia;
import dao.negocio.Telefono;
import mvc.view.VistaPrincipal;

public class ControladorCliente implements ActionListener{

	VistaPrincipal vista;
	ClienteDAO clienteDAO;
	DireccionDAO direccionDAO;
	TelefonoDAO telefonoDAO;
	
	
	
	public ControladorCliente(VistaPrincipal vista) {
		this.vista = vista;
		clienteDAO = new Factory().getClienteDaoImplMysql();
		direccionDAO = new Factory().getDireccionDaoImplMysql();
		telefonoDAO = new Factory().getTelefonoDaoImplMysql();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.vista.agregarCliente) {
			String nombre = JOptionPane.showInputDialog(null, "Nombre: ");
			String apellido = JOptionPane.showInputDialog(null, "Apellido: ");
			String dni = JOptionPane.showInputDialog(null, "Dni: ");
			String cuit = JOptionPane.showInputDialog(null, "CUIT-CUIL: ");
			String nacimiento = JOptionPane.showInputDialog(null, "Fecha de nacimiento: ");
			String email = JOptionPane.showInputDialog(null, "Email: ");
			
			String calle = JOptionPane.showInputDialog(null, "Calle: ", "Direcci�n");
			String altura = JOptionPane.showInputDialog(null, "Altura: ", "Direcci�n");
			String ciudad = JOptionPane.showInputDialog(null, "Ciudad: ", "Direcci�n");
			String codigoP = JOptionPane.showInputDialog(null, "C�digo postal: ", "Direcci�n");
			String provincia = JOptionPane.showInputDialog(null, "Provincia: ", "Direcci�n");
			String pais = JOptionPane.showInputDialog(null, "Pa�s: ", "Direcci�n");
			
			
			
			String celular = JOptionPane.showInputDialog(null, "Celular: ", "Tel�fono");
			String laboral = JOptionPane.showInputDialog(null, "Laboral: ", "Tel�fono");
			String personal = JOptionPane.showInputDialog(null, "Personal: ", "Tel�fono");
			Telefono tel = new Telefono(celular, laboral, personal);
			telefonoDAO.addTelefono(tel);
			
			
			String numeroPas = JOptionPane.showInputDialog(null, "N�mero de pasaporte: ", "Pasaporte");
			String autoridad = JOptionPane.showInputDialog(null, "Autoridad de emisi�n: ", "Pasaporte");
			String emision = JOptionPane.showInputDialog(null, "Fecha de emisi�n: ", "Pasaporte");
			String vencimiento = JOptionPane.showInputDialog(null, "Fecha de vencimiento: ", "Pasaporte");
			String paisEmision = JOptionPane.showInputDialog(null, "Pa�s de emisi�n: ", "Pasaporte");
			
			String categoria = JOptionPane.showInputDialog(null, "Categor�a: ", "Pasajero Frecuente");
			String numeroPF = JOptionPane.showInputDialog(null, "N�mero: ", "Pasajero Frecuente");
			String alianzaPF = JOptionPane.showInputDialog(null, "Alianza: ", "Pasajero Frecuente");
			String aerolineaPF = JOptionPane.showInputDialog(null, "Aerol�nea: ", "Pasajero Frecuente");

			
		}
		
	}
	
	

}
