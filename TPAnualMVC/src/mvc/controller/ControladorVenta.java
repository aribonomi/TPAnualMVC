package mvc.controller;

import java.util.List;

import javax.swing.JOptionPane;

import Factory.FactoryVenta;
import Factory.FactoryVuelo;
import dao.Interfaces.VentasDAO;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Venta;

public class ControladorVenta {
	
	VentasDAO ventaDAO;
	VuelosDAO vueloDAO;
	
	public ControladorVenta() {
		
	//Llamo a la implementación mediante el factory	
		new FactoryVenta();
		new FactoryVuelo();
		ventaDAO = FactoryVenta.getVentasDaoImplMysql();
		vueloDAO = FactoryVuelo.getVuelosDaoImplMysql();
	}
	
	public void altaVenta(Venta v) {
		LogicaVenta.realizarAltaVenta(v);
	}
	
	public boolean bajaVenta(String id) {
		return ventaDAO.bajaVenta(id);
	}
	
	public boolean modVenta(Venta v) {
		return ventaDAO.modificarVenta(v);
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
