package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.*;
import dao.negocio.Vuelo;
import mvc.controller.*;
import mvc.view.VistaVenta;
import mvc.view.VistaVenta2;

public class EventoVenta implements ActionListener{
	
//Se llama a los controladores y la vista de la venta	
	VistaVenta2 vista;
	ControladorCliente contCliente;
	ControladorVuelo contVuelo;
	ControladorLineaAerea contLA;
	ControladorVenta contVenta;

	public EventoVenta(VistaVenta2 vista) {
		super();
		this.vista = vista;
		contCliente = new ControladorCliente();
		contVuelo = new ControladorVuelo();
		contLA = new ControladorLineaAerea();
		contVenta = new ControladorVenta();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	//Alta	
		if(e.getSource()==vista.btnAgregar) {
			try {
			
			//Obtiene los valores de los campos	
				String fecha = vista.tf_fecha.getText();
				String forma_pago = (String) vista.comboFormaPago.getSelectedItem();
				
			//Si paga con crédito, concatena en la forma de pago las cuotas a pagar	
				if(forma_pago.equalsIgnoreCase("Crédito")) {
					forma_pago = forma_pago.concat(" "+(String) vista.comboCuotas.getSelectedItem());
				}
				
				Integer id_cliente = (Integer) vista.comboCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.comboVuelo.getSelectedItem();
				
				
				
			//Obtiene los objetos contenidos mediante los ids ingresados	
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(fecha, forma_pago, cliente, vuelo, aerolinea);
				
				if(contVenta.altaVenta(venta)) {
					JOptionPane.showMessageDialog(null, "Venta ingresada!", "Alta", JOptionPane.INFORMATION_MESSAGE);
				}
			
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar en la venta/vuelo/cliente/aerolinea", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			
	//Consulta	
		}else if(e.getSource()==vista.btnConsultar) {
			try {
			//Se consulta la venta mediante el campo id	
				Integer id = Integer.parseInt(vista.tf_id.getText());
				Venta venta = contVenta.consultarVenta(id);
//				Cliente cliente = contCliente.consultaPorId(venta.getCliente().getId_cliente());
//				Vuelo vuelo = contVuelo.consultarVuelo(venta.getVuelo().getId_Vuelo());
//				Aerolinea aerolinea = contLA.consultarLineaAerea(venta.getAerolinea().getId_aeroLinea().toString());
//				
//				venta.setCliente(cliente);
//				venta.setVuelo(vuelo);
//				venta.setAerolinea(aerolinea);
				
				
			//Se completan los campos en la consulta	
				vista.tf_fecha.setText(venta.getFecha());
				vista.comboFormaPago.setSelectedItem(contVenta.obtenerFormaPago(venta.getFormaDePago()));
				vista.comboCuotas.setSelectedItem(contVenta.obtenerCuotas(venta.getFormaDePago()));
				vista.comboCliente.setSelectedItem(venta.getCliente().getId_cliente());
				vista.comboVuelo.setSelectedItem(venta.getVuelo().getId_Vuelo());
				vista.comboAerolinea.setSelectedItem(venta.getAerolinea().getNombre());
				vista.resultado.setText(venta.toString());
				
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que el id ingresado exista", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}
		
	//Modificación		
		}else if(e.getSource()==vista.btnModificar) {
			try {
			//Obtiene los datos de la venta y realiza la modificación	
				Integer id = Integer.parseInt(vista.tf_id.getText());
				String fecha = vista.tf_fecha.getText();
				String forma_pago = (String) vista.comboFormaPago.getSelectedItem();
				
				if(forma_pago.equalsIgnoreCase("Crédito")) {
					forma_pago = forma_pago.concat(" "+(String) vista.comboCuotas.getSelectedItem());
				}
				
				Integer id_cliente = (Integer) vista.comboCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.comboVuelo.getSelectedItem();
				
			//Se obtienen los objetos mediante sus ids	
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(id, cliente, vuelo, aerolinea, fecha, forma_pago);
				
				if(contVenta.modVenta(venta)) {
					JOptionPane.showMessageDialog(null, "Venta modificada!", "Modificación", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al modificar", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			
	//Eliminación	
		}else if(e.getSource()==vista.btnEliminar) {
			try {
			//Confirma la eliminación	
				int input =JOptionPane.showConfirmDialog(null, "¡Se eliminará la venta!", "WARNING", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(input == JOptionPane.OK_OPTION) {
					if(contVenta.bajaVenta(vista.tf_id.getText())) {
						JOptionPane.showMessageDialog(null, "Venta eliminada!", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que el id ingresado exista", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		
	//Vuelve al menú	
		}else if(e.getSource()==vista.btnAtras) {
			vista.setVisible(false);
		}
		
	}
	
	

}
