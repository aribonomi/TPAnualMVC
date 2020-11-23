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
				String forma_pago = vista.textFieldFormaDePago.getText();
				Integer id_cliente = (Integer) vista.comboBoxCliente.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboBoxAerolinea.getSelectedItem();
				Integer id_vuelo = (Integer)vista.comboBoxVuelo.getSelectedItem();
				
				
				
				Cliente cliente=contCliente.consultaPorId(id_cliente);
				Vuelo vuelo = contVuelo.consultarVuelo(id_vuelo);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				
				Venta venta = new Venta(fecha, forma_pago, cliente, vuelo, aerolinea);
				
				contVenta.altaVenta(venta);
				
			}else if(e.getSource()==vista.btnConsulta) {
				Integer id = Integer.parseInt(vista.comboBoxId.getSelectedItem().toString());
				Venta venta = contVenta.consultarVenta(id);
				
				
				vista.ModtextFieldFecha.setText(venta.getFecha());
				vista.ModtextFieldFormaDePago.setText(venta.getFormaDePago());
				vista.modcomboBoxCliente.setSelectedItem(venta.getCliente().getId_cliente());
				vista.modcomboBoxVuelo.setSelectedItem(venta.getVuelo().getId_Vuelo());
				vista.modcomboBoxAerolinea.setSelectedItem(venta.getAerolinea().getNombre());
				
			}else if(e.getSource()==vista.btnModificarVenta) {
				Integer id = Integer.parseInt(vista.comboBoxId.getSelectedItem().toString());
				String fecha = vista.ModtextFieldFecha.getText();
				String forma_pago = vista.ModtextFieldFormaDePago.getText();
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
					contVenta.bajaVenta(vista.comboBoxId.getSelectedItem().toString());
				}
			}else if(e.getSource()==vista.btnAtras) {
				vista.setVisible(false);
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
		
	}
	
	

}
