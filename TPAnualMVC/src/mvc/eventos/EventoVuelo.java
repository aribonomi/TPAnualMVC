package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.Aerolinea;
import dao.negocio.Aeropuerto;
import dao.negocio.Vuelo;
import mvc.controller.*;
import mvc.view.VistaVuelo;

public class EventoVuelo implements ActionListener{
	
	VistaVuelo vista;
	ControladorVuelo contVuelo;
	ControladorAeropuerto contAeropuerto;
	ControladorLineaAerea contLA;
	
	

	public EventoVuelo(VistaVuelo vista) {
		super();
		this.vista = vista;
		contVuelo = new ControladorVuelo();
		contAeropuerto = new ControladorAeropuerto();
		contLA = new ControladorLineaAerea();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==vista.btnAlta) {
				String numero = vista.textFieldNumero.getText();
				Integer cantidad_asientos = Integer.parseInt(vista.textFieldCantidadDeAsientos.getText());
				String nombre_aerop_llegada = (String) vista.comboBoxAeropLlegada.getSelectedItem();
				String nombre_aerop_salida = (String) vista.comboBoxAeropSalida.getSelectedItem();
				String fecha_salida = vista.textFieldFechaSalida.getText();
				String fecha_llegada = vista.textFieldFechaLlegada.getText();
				String tiempo_vuelo = vista.textFieldTiempoVuelo.getText();
				String nombre_aerolinea = (String) vista.comboBoxAerolinea.getSelectedItem();
				
				Aeropuerto aeropuerto_salida=contAeropuerto.consultaPorCodigo(nombre_aerop_salida);
				Aeropuerto aeropuerto_llegada = contAeropuerto.consultaPorCodigo(nombre_aerop_llegada);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				Vuelo vuelo = new Vuelo(numero, cantidad_asientos, fecha_llegada, fecha_salida, tiempo_vuelo,aeropuerto_llegada, aeropuerto_salida, aerolinea);
				
				contVuelo.altaVuelo(vuelo);
				
			}else if(e.getSource()==vista.btnConsultar) {
				Integer id = Integer.parseInt(vista.comboBoxID.getSelectedItem().toString());
				Vuelo vuelo = contVuelo.consultarVuelo(id);
				
				
				vista.ModtextFieldNumero.setText(vuelo.getNumero());
				vista.ModtextFieldCantidadAsientos.setText(vuelo.getCantidadAsientos().toString());
				vista.ModtextFieldFechaSalida.setText(vuelo.getFechaSalida());
				vista.ModtextFieldFechaLlegada.setText(vuelo.getFechaLlegada());
				vista.ModtextFieldTiempoVuelo.setText(vuelo.getTiempoVuelo());
				vista.modcomboBoxAerolinea.setSelectedItem(vuelo.getAerolinea().getNombre());
				vista.modcomboBoxAeropSalida.setSelectedItem(vuelo.getAeropuertoSalida().getIdentificacion());
				vista.modcomboBoxAeropLlegada.setSelectedItem(vuelo.getAeropuertoLlegada().getIdentificacion());
				
			}else if(e.getSource()==vista.btnModificar) {
				Integer id = Integer.parseInt(vista.comboBoxID.getSelectedItem().toString());
				String numero = vista.ModtextFieldNumero.getText();
				Integer cantidad_asientos = Integer.parseInt(vista.ModtextFieldCantidadAsientos.getText());
				String nombre_aerop_llegada = (String) vista.modcomboBoxAeropLlegada.getSelectedItem();
				String nombre_aerop_salida = (String) vista.modcomboBoxAeropSalida.getSelectedItem();
				String fecha_salida = vista.ModtextFieldFechaSalida.getText();
				String fecha_llegada = vista.ModtextFieldFechaLlegada.getText();
				String tiempo_vuelo = vista.ModtextFieldTiempoVuelo.getText();
				String nombre_aerolinea = (String) vista.modcomboBoxAerolinea.getSelectedItem();
				
				Aeropuerto aeropuerto_salida=contAeropuerto.consultaPorCodigo(nombre_aerop_salida);
				Aeropuerto aeropuerto_llegada = contAeropuerto.consultaPorCodigo(nombre_aerop_llegada);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				Vuelo vuelo = new Vuelo(id, numero, cantidad_asientos, fecha_llegada, fecha_salida, tiempo_vuelo,aeropuerto_llegada, aeropuerto_salida, aerolinea);
				
				contVuelo.modVuelo(vuelo);
			}else if(e.getSource()==vista.btnEliminar) {
				int input =JOptionPane.showConfirmDialog(null, "¡Se eliminará el vuelo!", "WARNING", JOptionPane.OK_CANCEL_OPTION);
				if(input == JOptionPane.OK_OPTION) {
					contVuelo.bajaVuelo(vista.comboBoxID.getSelectedItem().toString());
				}if(input==JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Jajaja alto cagón");
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
