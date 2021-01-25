package mvc.controller;

import java.util.List;

import Factory.FactoryCliente;
import dao.Interfaces.ClienteDAO;
import dao.negocio.Cliente;
import dao.negocio.Direccion;
import dao.negocio.PasajeroFrecuente;
import dao.negocio.Pasaporte;
import dao.negocio.Telefono;


public class ControladorCliente {

	ClienteDAO clienteDAO;
	ControladorDireccion contDireccion;
	ControladorTelefono contTelefono;
	ControladorPasaporte contPasaporte;
	ControladorPasajeroFrecuente contPF;
	
	
	
	public ControladorCliente() {

	//Llamo a la implementación mediante el factory	
		new FactoryCliente();
		clienteDAO = FactoryCliente.getClienteDaoImplMysql();
		contDireccion = new ControladorDireccion();
		contTelefono = new ControladorTelefono();
		contPasaporte = new ControladorPasaporte();
		contPF = new ControladorPasajeroFrecuente();
	}



	public boolean altaCliente(Cliente c) {
		
		return clienteDAO.altaCliente(c);
	}
	
	public boolean bajaCliente(String id) {
		return clienteDAO.bajaCliente(id);
	}
	
	public boolean modificarCliente(Cliente c) {
		return clienteDAO.modificarCliente(c);		
	}
	
	public Cliente consultarCliente(String id) {
		return clienteDAO.getCliente(id);
	}
	
	public Cliente consultaPorId(Integer id) {
		Cliente cliente = clienteDAO.consultaPorId(id);
		
		Direccion direccion = contDireccion.consultar(cliente.getdireccion().getId_direccion().toString());
		Telefono t = contTelefono.consultarTelefono(cliente.gettelefono().getId_Telefono().toString());
		Pasaporte p = contPasaporte.consultarPasaporte(cliente.getpasaporte().getId_Pasaporte().toString());
		PasajeroFrecuente pf = contPF.consultarPasajeroFrecuente(cliente.getpasajeroFrecuente().getId_pasajeroFrecuente().toString());
		
		cliente.setId_direccion(direccion);
		cliente.setId_telefono(t);
		cliente.setId_pasaporte(p);
		cliente.setpasajeroFrecuente(pf);
		
		return cliente;
	}
	
	public List<Integer> obtenerIds(){
		return clienteDAO.obtenerIDs();
	}
	
	public Cliente obtenerUltimo() {
		return clienteDAO.obtenerUltimo();
	}
		
}
	
	


