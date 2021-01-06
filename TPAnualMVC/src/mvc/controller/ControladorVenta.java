package mvc.controller;

import java.util.List;

import javax.swing.JOptionPane;

import Factory.Factory;
import dao.Interfaces.VentasDAO;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Venta;

public class ControladorVenta {
	
	VentasDAO ventaDAO;
	VuelosDAO vueloDAO;
	
	public ControladorVenta() {
		
	//Llamo a la implementación mediante el factory	
		new Factory();
		ventaDAO = Factory.getVentasDaoImplMysql();
		vueloDAO = Factory.getVuelosDaoImplMysql();
	}
	
	public void altaVenta(Venta v) {
		LogicaVenta.realizarAltaVenta(v);
	}
	
	public void bajaVenta(String id) {
		ventaDAO.bajaVenta(id);
	}
	
	public void modVenta(Venta v) {
		ventaDAO.modificarVenta(v);
	}
	
	public Venta consultarVenta(Integer id) {
		try {
			return ventaDAO.getVentas(id.toString());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "La venta consultada no existe", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return null;
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
