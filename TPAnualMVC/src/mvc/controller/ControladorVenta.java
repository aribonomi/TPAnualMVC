package mvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		//return LogicaVenta.realizarAltaVenta(v);
		try {
			
			//Paso las fechas en String al formato Date yyyy-MM-dd	
				LocalDate fecha_emision = LocalDate.parse(v.getCliente().getpasaporte().getFechaEmision(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				LocalDate fecha_vencimiento = LocalDate.parse(v.getCliente().getpasaporte().getFechaVencimiento(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				LocalDate nacimiento = LocalDate.parse(v.getCliente().getFecha_nacimiento(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				
			//Si no hay asientos disponibles, no se efectuará la venta	
				if(v.getVuelo().getCantidadAsientos()>0) {
					
				//Si la fehca de emisión no es anterior a la fecha de hoy y el pasaporte está vencido, no se efectuará la venta	
					if(fecha_emision.isBefore(LocalDate.now()) && fecha_vencimiento.isAfter(LocalDate.now())) {
						
					//Si el cliente tiene menos de 18 años, no se efectuará la venta	
						if((LocalDate.now().getYear()-nacimiento.getYear())>=18) {
							
						//Se efectúa la venta y se reduce en 1 la cantidad de asientos en el vuelo	
							ventaDAO.altaVenta(v);
							v.getVuelo().setCantidadAsientos(v.getVuelo().getCantidadAsientos()-1);
							contVuelo.modVuelo(v.getVuelo());
							return true;
						}else {
							JOptionPane.showMessageDialog(null, "El cliente tiene menos de 18 años. Fecha de nacimiento: "+nacimiento,"Error", JOptionPane.ERROR_MESSAGE);
							return false;
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "La fecha de emisión del pasaporte "+fecha_emision+" es posterior a la fecha actual"
								+ " o su pasaporte está vencido", "Error",JOptionPane.ERROR_MESSAGE);
						return false;
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "No hay asientos disponibles", "Error",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Verifique que la fecha de nacimiento del cliente sea yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				return false;
			}
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
