package mvc.controller;

import Factory.Factory;
import dao.Interfaces.VentasDAO;
import dao.negocio.Venta;

public class ControladorVenta {
	
	VentasDAO ventaDAO;
	
	public ControladorVenta() {
		new Factory();
		ventaDAO = Factory.getVentasDaoImplMysql();
	}
	
	public void altaVenta(Venta v) {
		ventaDAO.altaVenta(v);
	}
	
	public void bajaVenta(String id) {
		ventaDAO.bajaVenta(id);
	}
	
	public void modVenta(Venta v) {
		ventaDAO.modificarVenta(v);
	}
	
	public Venta consultarVenta(String id) {
		return ventaDAO.getVentas(id);
	}

}
