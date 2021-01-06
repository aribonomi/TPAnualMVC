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
		return clienteDAO.obtenerIDs();
	}
	
	public Cliente obtenerUltimo() {
		return clienteDAO.obtenerUltimo();
	}
		
}
	
	


