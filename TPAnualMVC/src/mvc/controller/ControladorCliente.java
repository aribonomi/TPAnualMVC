package mvc.controller;

import java.util.List;

import Factory.FactoryCliente;
import dao.Interfaces.ClienteDAO;
import dao.negocio.Cliente;


public class ControladorCliente {

	ClienteDAO clienteDAO;
	
	
	
	public ControladorCliente() {

	//Llamo a la implementación mediante el factory	
		new FactoryCliente();
		clienteDAO = FactoryCliente.getClienteDaoImplMysql();

	}



	public boolean altaCliente(Cliente c) {
		
		if(clienteDAO.altaCliente(c)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean bajaCliente(String id) {
		if(clienteDAO.bajaCliente(id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean modificarCliente(Cliente c) {
		if(clienteDAO.modificarCliente(c)) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public Cliente consultarCliente(String id) {
		return clienteDAO.getCliente(id);
	}
	
	public Cliente consultaPorId(Integer id) {
		return clienteDAO.consultaPorId(id);
	}
	
	public List<Integer> obtenerIds(){
		return clienteDAO.obtenerIDs();
	}
	
	public Cliente obtenerUltimo() {
		return clienteDAO.obtenerUltimo();
	}
		
}
	
	


