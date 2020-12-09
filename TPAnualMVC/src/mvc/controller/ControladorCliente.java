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
		//Date fecha=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); 
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
	
	public Cliente obtenerUltimo() {
		return clienteDAO.obtenerUltimo();
	}
		
}
	
	


