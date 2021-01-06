package mvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import Factory.FactoryVenta;
import Factory.FactoryVuelo;
import dao.Interfaces.VentasDAO;
import dao.Interfaces.VuelosDAO;
import dao.negocio.Venta;

public class LogicaVenta {
	
	static VentasDAO ventaDAO;
	static VuelosDAO vueloDAO;
		
	public LogicaVenta() {
	//Llamo a la implementación mediante el factory	
		new FactoryVenta();
		new FactoryVuelo();
		ventaDAO = FactoryVenta.getVentasDaoImplMysql();
		vueloDAO = FactoryVuelo.getVuelosDaoImplMysql();
	}
	
	public static void realizarAltaVenta(Venta v) {
		
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
						vueloDAO.modificarVuelo(v.getVuelo());
					}else {
						JOptionPane.showMessageDialog(null, "El cliente tiene menos de 18 años. Fecha de nacimiento: "+nacimiento,"Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "La fecha de emisión del pasaporte "+fecha_emision+" es posterior a la fecha actual"
							+ " o su pasaporte está vencido", "Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "No hay asientos disponibles", "Error",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Verifique que la fecha de nacimiento del cliente sea yyyy-MM-dd", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	//Logica para ver si la venta existe
	
	public static String obtenerFormaPago(String forma_pago) {
		//Método para determinar qué forma de pago se eligió cuando se realiza la consulta	
		if(forma_pago.startsWith("C")) {
			return "Crédito";
		}else if(forma_pago.startsWith("E")) {
			return "Efectivo";
		}else if(forma_pago.startsWith("D")) {
			return "Débito";
		}
		return null;
	}
	
	
	public static String obtenerCuotasLogica(String cuotas) {
		//Método para determinar en cuántas cuotas pagó cuando se realiza la consulta	
				if(cuotas.contains("3")) {
					return "3 s/i";
				}else if(cuotas.contains("6")) {
					return "6 s/i";
				}else if(cuotas.contains("12")) {
					return "12 (10% interes)";
				}else if(cuotas.contains("24")) {
					return "24 (10% interes)";
				}
				return null;
	}
	
	
	
	
	

}
