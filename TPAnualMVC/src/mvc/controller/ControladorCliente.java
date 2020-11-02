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
			
			String calle = JOptionPane.showInputDialog(null, "Calle: ", "Dirección");
			String altura = JOptionPane.showInputDialog(null, "Altura: ", "Dirección");
			String ciudad = JOptionPane.showInputDialog(null, "Ciudad: ", "Dirección");
			String codigoP = JOptionPane.showInputDialog(null, "Código postal: ", "Dirección");
			String provincia = JOptionPane.showInputDialog(null, "Provincia: ", "Dirección");
			String pais = JOptionPane.showInputDialog(null, "País: ", "Dirección");
			
			
			
			String celular = JOptionPane.showInputDialog(null, "Celular: ", "Teléfono");
			String laboral = JOptionPane.showInputDialog(null, "Laboral: ", "Teléfono");
			String personal = JOptionPane.showInputDialog(null, "Personal: ", "Teléfono");
			Telefono tel = new Telefono(celular, laboral, personal);
			telefonoDAO.addTelefono(tel);
			
			
			String numeroPas = JOptionPane.showInputDialog(null, "Número de pasaporte: ", "Pasaporte");
			String autoridad = JOptionPane.showInputDialog(null, "Autoridad de emisión: ", "Pasaporte");
			String emision = JOptionPane.showInputDialog(null, "Fecha de emisión: ", "Pasaporte");
			String vencimiento = JOptionPane.showInputDialog(null, "Fecha de vencimiento: ", "Pasaporte");
			String paisEmision = JOptionPane.showInputDialog(null, "País de emisión: ", "Pasaporte");
			
			String categoria = JOptionPane.showInputDialog(null, "Categoría: ", "Pasajero Frecuente");
			String numeroPF = JOptionPane.showInputDialog(null, "Número: ", "Pasajero Frecuente");
			String alianzaPF = JOptionPane.showInputDialog(null, "Alianza: ", "Pasajero Frecuente");
			String aerolineaPF = JOptionPane.showInputDialog(null, "Aerolínea: ", "Pasajero Frecuente");

			
		}
		
	}
	
	

}
