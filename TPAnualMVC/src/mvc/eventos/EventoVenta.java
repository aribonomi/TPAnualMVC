package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.*;
import dao.negocio.Vuelo;
import mvc.controller.*;
import mvc.view.VistaVenta;

public class EventoVenta implements ActionListener{
	
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
		try {
			if(e.getSource()==vista.btnAgregar) {
				String fecha = vista.textFieldFecha.getText();
				String forma_pago = (String) vista.comboBoxFormaPago.getSelectedItem();
				
				if(forma_pago.equalsIgnoreCase("Crédito")) {
					forma_pago = forma_pago.concat(" "+(String) vista.comboBoxIntereses.getSelectedItem());
				}
				
				Integer id_cliente = (Integer) vista.comboBoxCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboBoxAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.comboBoxVuelo.getSelectedItem();
				
				
				
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(fecha, forma_pago, cliente, vuelo, aerolinea);
				
				contVenta.altaVenta(venta);
				Venta ventaAgregada = contVenta.obtenerUltima();
				
				JOptionPane.showMessageDialog(null,  ventaAgregada.toString(), "Venta ingresada", JOptionPane.INFORMATION_MESSAGE);
				
				
			}else if(e.getSource()==vista.btnConsulta) {
				Integer id = Integer.parseInt(vista.textField_idVenta.getText());
				Venta venta = contVenta.consultarVenta(id);
				
				
				vista.ModtextFieldFecha.setText(venta.getFecha());
				vista.modcomboBox_formaPago.setSelectedItem(contVenta.obtenerFormaPago(venta.getFormaDePago()));
				vista.modcomboBoxIntereses.setSelectedItem(contVenta.obtenerCuotas(venta.getFormaDePago()));
				vista.modcomboBoxCliente.setSelectedItem(venta.getCliente().getId_cliente());
				vista.modcomboBoxVuelo.setSelectedItem(venta.getVuelo().getId_Vuelo());
				vista.modcomboBoxAerolinea.setSelectedItem(venta.getAerolinea().getNombre());
				vista.textAreaConsulta.setText(venta.toString());
				
			}else if(e.getSource()==vista.btnModificarVenta) {
				Integer id = Integer.parseInt(vista.textField_idVenta.getText());
				String fecha = vista.ModtextFieldFecha.getText();
				String forma_pago = (String) vista.modcomboBox_formaPago.getSelectedItem();
				
				if(forma_pago.equalsIgnoreCase("Crédito")) {
					forma_pago = forma_pago.concat(" "+(String) vista.modcomboBoxIntereses.getSelectedItem());
				}
				
				Integer id_cliente = (Integer) vista.modcomboBoxCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.modcomboBoxAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.modcomboBoxVuelo.getSelectedItem();
				
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(id, cliente, vuelo, aerolinea, fecha, forma_pago);
				
				contVenta.modVenta(venta);
				
			}else if(e.getSource()==vista.btnEliminar) {
				int input =JOptionPane.showConfirmDialog(null, "¡Se eliminará la venta!", "WARNING", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(input == JOptionPane.OK_OPTION) {
					contVenta.bajaVenta(vista.textField_idVenta.getText());
				}
			}else if(e.getSource()==vista.btnAtras) {
				vista.setVisible(false);
			}
		}catch(NullPointerException np) {
			JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar en la venta/vuelo/cliente/aerolinea", "Error", JOptionPane.ERROR_MESSAGE);
			np.printStackTrace();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
		
	}
	
	

}
