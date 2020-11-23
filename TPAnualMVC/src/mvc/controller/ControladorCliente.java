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
		*/
		
	}
	
	


