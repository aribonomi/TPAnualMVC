package mvc.controller;

import java.util.List;

import javax.swing.JOptionPane;

import Factory.FactoryVenta;
import dao.Interfaces.VentasDAO;

import dao.negocio.*;

public class ControladorVenta {
	
	VentasDAO ventaDAO;
	ControladorCliente contCliente;
	ControladorVuelo contVuelo;
	ControladorLineaAerea contLA;
	
	
	public ControladorVenta() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryVenta();
		ventaDAO = FactoryVenta.getVentasDaoImplMysql();
		contVuelo = new ControladorVuelo();
		contCliente = new ControladorCliente();
		contLA = new ControladorLineaAerea();
		
	}
	
	public boolean altaVenta(Venta v) {
		return LogicaVenta.realizarAltaVenta(v);
	}
	
	public boolean bajaVenta(String id) {
		return ventaDAO.bajaVenta(id);
	}
	
	public boolean modVenta(Venta v) {
		return ventaDAO.modificarVenta(v);
	}
	
	public Venta consultarVenta(Integer id) {
		Venta venta = ventaDAO.getVentas(id.toString());
		Cliente cliente = contCliente.consultaPorId(venta.getCliente().getId_cliente());
		Vuelo vuelo = contVuelo.consultarVuelo(venta.getVuelo().getId_Vuelo());
		Aerolinea aerolinea = contLA.consultarLineaAerea(venta.getAerolinea().getId_aeroLinea().toString());
		
		venta.setCliente(cliente);
		venta.setVuelo(vuelo);
		venta.setAerolinea(aerolinea);
		
		return venta;
	}
	
	public List<Integer> obtenerIds(){
		return ventaDAO.obtenerIds();
	}
	
	public Venta obtenerUltima() {
		return ventaDAO.obtenerUltima();
	}
	
	public String obtenerFormaPago(String forma_pago) {
		String FormaDePago = LogicaVenta.obtenerFormaPago(forma_pago);
		return FormaDePago;
	}
	
	public String obtenerCuotas(String cuotas) {
		String RespuestaCuotas = LogicaVenta.obtenerCuotasLogica(cuotas);
		return RespuestaCuotas;
	}
	

}
