package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.*;
import dao.negocio.Vuelo;
import mvc.controller.*;
import mvc.view.VistaVenta;

public class EventoVenta implements ActionListener{
	
//Se llama a los controladores y la vista de la venta	
	VistaVenta vista;
	ControladorCliente contCliente;
	ControladorVuelo contVuelo;
	ControladorLineaAerea contLA;
	ControladorVenta contVenta;

	public EventoVenta(VistaVenta vista) {
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
				String fecha = vista.textFieldFecha.getText();
				String forma_pago = (String) vista.comboBoxFormaPago.getSelectedItem();
				
			//Si paga con crédito, concatena en la forma de pago las cuotas a pagar	
				if(forma_pago.equalsIgnoreCase("Crédito")) {
					forma_pago = forma_pago.concat(" "+(String) vista.comboBoxIntereses.getSelectedItem());
				}
				
				Integer id_cliente = (Integer) vista.comboBoxCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboBoxAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.comboBoxVuelo.getSelectedItem();
				
				
				
			//Obtiene los objetos contenidos mediante los ids ingresados	
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(fecha, forma_pago, cliente, vuelo, aerolinea);
				
				contVenta.altaVenta(venta);
			
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar en la venta/vuelo/cliente/aerolinea", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			
	//Consulta	
		}else if(e.getSource()==vista.btnConsulta) {
			try {
			//Se consulta la venta mediante el campo id	
				Integer id = Integer.parseInt(vista.textField_idVenta.getText());
				Venta venta = contVenta.consultarVenta(id);
				
				
			//Se completan los campos en la consulta	
				vista.ModtextFieldFecha.setText(venta.getFecha());
				vista.modcomboBox_formaPago.setSelectedItem(contVenta.obtenerFormaPago(venta.getFormaDePago()));
				vista.modcomboBoxIntereses.setSelectedItem(contVenta.obtenerCuotas(venta.getFormaDePago()));
				vista.modcomboBoxCliente.setSelectedItem(venta.getCliente().getId_cliente());
				vista.modcomboBoxVuelo.setSelectedItem(venta.getVuelo().getId_Vuelo());
				vista.modcomboBoxAerolinea.setSelectedItem(venta.getAerolinea().getNombre());
				vista.textAreaConsulta.setText(venta.toString());
				
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que el id ingresado exista", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}
		
	//Modificación		
		}else if(e.getSource()==vista.btnModificarVenta) {
			try {
			//Obtiene los datos de la venta y realiza la modificación	
				Integer id = Integer.parseInt(vista.textField_idVenta.getText());
				String fecha = vista.ModtextFieldFecha.getText();
				String forma_pago = (String) vista.modcomboBox_formaPago.getSelectedItem();
				
				if(forma_pago.equalsIgnoreCase("Crédito")) {
					forma_pago = forma_pago.concat(" "+(String) vista.modcomboBoxIntereses.getSelectedItem());
				}
				
				Integer id_cliente = (Integer) vista.modcomboBoxCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.modcomboBoxAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.modcomboBoxVuelo.getSelectedItem();
				
			//Se obtienen los objetos mediante sus ids	
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(id, cliente, vuelo, aerolinea, fecha, forma_pago);
				
				contVenta.modVenta(venta);
				
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
					contVenta.bajaVenta(vista.textField_idVenta.getText());
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
