package mvc.controller;

import java.util.List;

import Factory.Factory;
import dao.Interfaces.ClienteDAO;
import dao.negocio.Cliente;


public class ControladorCliente {

	ClienteDAO clienteDAO;
	
	
	
	public ControladorCliente() {

		new Factory();
		clienteDAO = Factory.getClienteDaoImplMysql();

	}



	public void altaCliente(Cliente c) {
		clienteDAO.altaCliente(c);
		
	}
	
	public void bajaCliente(String id) {
		clienteDAO.bajaCliente(id);
	}
	
	public void modificarCliente(Cliente c) {
		clienteDAO.modificarCliente(c);
	}
	
	public Cliente consultarCliente(String id) {
		return clienteDAO.getCliente(id);
	}
	
	public Cliente consultaPorId(Integer id) {
		return clienteDAO.consultaPorId(id);
	}
	
	public List<Integer> obtenerIds(){
		return clienteDAO.obtenerDnis();
	}
	
	/*
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
		*/
		
	}
	
	


