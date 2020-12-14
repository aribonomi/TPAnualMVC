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
	
//Llama a los controladores y a la vista	
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
		
	//Alta	
		if(e.getSource()==vista.btnAlta) {
			try {
			//Obtiene los valores de los campos	
				Integer cantidad_asientos = Integer.parseInt(vista.textFieldCantidadDeAsientos.getText());
				String nombre_aerop_llegada = (String) vista.comboBoxAeropLlegada.getSelectedItem();
				String nombre_aerop_salida = (String) vista.comboBoxAeropSalida.getSelectedItem();
				String fecha_salida = vista.textFieldFechaSalida.getText();
				String fecha_llegada = vista.textFieldFechaLlegada.getText();
				String tiempo_vuelo = vista.textFieldTiempoVuelo.getText();
				String nombre_aerolinea = (String) vista.comboBoxAerolinea.getSelectedItem();
				
			//Forma el número de vuelo mediante el id y el nombre de la aerolínea	
				Integer id_vuelo = contVuelo.obtenerUltimoId()+1;
				
				String numero_vuelo = formarNumeroVuelo(nombre_aerolinea,id_vuelo); 
				
			//Obtiene los aeropuertos y la aerolínea mediante sus ids	
				Aeropuerto aeropuerto_salida=contAeropuerto.consultaPorCodigo(nombre_aerop_salida);
				Aeropuerto aeropuerto_llegada = contAeropuerto.consultaPorCodigo(nombre_aerop_llegada);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				Vuelo vuelo = new Vuelo(numero_vuelo, cantidad_asientos, fecha_llegada, fecha_salida, tiempo_vuelo,aeropuerto_llegada, aeropuerto_salida, aerolinea);
				vista.lblNumVuelo.setText(numero_vuelo);
				
				contVuelo.altaVuelo(vuelo);
				
			//Muestra el vuelo agregado por pantalla	
				Vuelo vueloAgregado = contVuelo.consultarVuelo(contVuelo.obtenerUltimoId());
				
				JOptionPane.showMessageDialog(null,  vueloAgregado.toString(), "Vuelo ingresado", JOptionPane.INFORMATION_MESSAGE);
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
				
			
	//Consulta	
		}else if(e.getSource()==vista.btnConsultar) {
			try {
			//Realiza la consulta mediante el id ingresado	
				Integer id = Integer.parseInt(vista.textFieldVueloCons.getText());
				Vuelo vuelo = contVuelo.consultarVuelo(id);
				
			//Setea los campos con los datos del vuelo consultado	
				vista.ModtextFieldNumero.setText(vuelo.getNumero());
				vista.ModtextFieldCantidadAsientos.setText(vuelo.getCantidadAsientos().toString());
				vista.ModtextFieldFechaSalida.setText(vuelo.getFechaSalida());
				vista.ModtextFieldFechaLlegada.setText(vuelo.getFechaLlegada());
				vista.ModtextFieldTiempoVuelo.setText(vuelo.getTiempoVuelo());
				vista.modcomboBoxAerolinea.setSelectedItem(vuelo.getAerolinea().getNombre());
				vista.modcomboBoxAeropSalida.setSelectedItem(vuelo.getAeropuertoSalida().getIdentificacion());
				vista.modcomboBoxAeropLlegada.setSelectedItem(vuelo.getAeropuertoLlegada().getIdentificacion());
				
				vista.textAreaConsulta.setText(vuelo.toString());
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que el id ingresado exista", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Verifique que los datos sean correctos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}					
			
	//Modificación	
		}else if(e.getSource()==vista.btnModificar) {
			try {
			//Se obtienen los campos de la consulta y se realiza la modificación	
				Integer id = Integer.parseInt(vista.textFieldVueloCons.getText());
				String numero = vista.ModtextFieldNumero.getText();
				Integer cantidad_asientos = Integer.parseInt(vista.ModtextFieldCantidadAsientos.getText());
				String nombre_aerop_llegada = (String) vista.modcomboBoxAeropLlegada.getSelectedItem();
				String nombre_aerop_salida = (String) vista.modcomboBoxAeropSalida.getSelectedItem();
				String fecha_salida = vista.ModtextFieldFechaSalida.getText();
				String fecha_llegada = vista.ModtextFieldFechaLlegada.getText();
				String tiempo_vuelo = vista.ModtextFieldTiempoVuelo.getText();
				String nombre_aerolinea = (String) vista.modcomboBoxAerolinea.getSelectedItem();
				
			//Se obtienen los aeropuertos y la aerolínea a través de sus códigos o nombre	
				Aeropuerto aeropuerto_salida=contAeropuerto.consultaPorCodigo(nombre_aerop_salida);
				Aeropuerto aeropuerto_llegada = contAeropuerto.consultaPorCodigo(nombre_aerop_llegada);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				Vuelo vuelo = new Vuelo(id, numero, cantidad_asientos, fecha_llegada, fecha_salida, tiempo_vuelo,aeropuerto_llegada, aeropuerto_salida, aerolinea);
				
				contVuelo.modVuelo(vuelo);
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
				int input =JOptionPane.showConfirmDialog(null, "¡Se eliminará el vuelo!", "WARNING", JOptionPane.OK_CANCEL_OPTION);
				if(input == JOptionPane.OK_OPTION) {
					contVuelo.bajaVuelo(vista.textFieldVueloCons.getText());
				}
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que el id ingresado exista", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
					
	//Vuelve al menú	
		}else if(e.getSource()==vista.btnAtras) {
			vista.setVisible(false);
		}
	}
	
	
	
	private String formarNumeroVuelo (String aerolinea, int numeroVuelo) {
		
		String codigoVuelo = null;
		
		int cantidadNumeros = 0;
		cantidadNumeros = Integer.toString(numeroVuelo).length();
		
		switch (cantidadNumeros){
		
		case 1:
		codigoVuelo = aerolinea.charAt(0) + "" + aerolinea.charAt(4) +"-000"+numeroVuelo;
		return codigoVuelo;
		case 2:
		codigoVuelo = aerolinea.charAt(0) + "" + aerolinea.charAt(4) +"-00"+numeroVuelo;
		return codigoVuelo;
		case 3:
		codigoVuelo = aerolinea.charAt(0) + "" + aerolinea.charAt(4) +"-0"+numeroVuelo;
		return codigoVuelo;
		case 4:
		codigoVuelo = aerolinea.charAt(0) + "" + aerolinea.charAt(4) +"-"+numeroVuelo;
		return codigoVuelo;
		default:
		codigoVuelo = aerolinea.charAt(0) + "" + aerolinea.charAt(4) +"-" +numeroVuelo;	
		return codigoVuelo;
		
		
		
		}
	}
	
	
	

}
