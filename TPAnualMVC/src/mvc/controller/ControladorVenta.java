package mvc.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
		new Factory();
		ventaDAO = Factory.getVentasDaoImplMysql();
		vueloDAO = Factory.getVuelosDaoImplMysql();
	}
	
	public void altaVenta(Venta v) {
		
		LocalDate fecha_emision = LocalDate.parse(v.getCliente().getpasaporte().getFechaEmision(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate fecha_vencimiento = LocalDate.parse(v.getCliente().getpasaporte().getFechaVencimiento(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate nacimiento = LocalDate.parse(v.getCliente().getFecha_nacimiento(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		if(v.getVuelo().getCantidadAsientos()>0) {
			if(fecha_emision.isBefore(LocalDate.now()) && fecha_vencimiento.isAfter(LocalDate.now())) {
				if((LocalDate.now().getYear()-nacimiento.getYear())>=18) {
					ventaDAO.altaVenta(v);
					v.getVuelo().setCantidadAsientos(v.getVuelo().getCantidadAsientos()-1);
					vueloDAO.modificarVuelo(v.getVuelo());
				}else {
					JOptionPane.showMessageDialog(null, "El cliente tiene menos de 18 a�os. Fecha de nacimiento: "+nacimiento,"Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "La fecha de emisi�n del pasaporte "+fecha_emision+" es posterior a la fecha actual"
						+ " o su pasaporte est� vencido", "Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "No hay asientos disponibles", "Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
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

}
