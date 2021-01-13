package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.Aerolinea;
import dao.negocio.Aeropuerto;
import dao.negocio.Vuelo;
import mvc.controller.*;
import mvc.view.VistaVuelo;
import mvc.view.VistaVuelo2;

public class EventoVuelo implements ActionListener{
	
//Llama a los controladores y a la vista	
	VistaVuelo2 vista;
	ControladorVuelo contVuelo;
	ControladorAeropuerto contAeropuerto;
	ControladorLineaAerea contLA;
	ControladorPais contPais;
	ControladorProvincia contProvincia;
	
	

	public EventoVuelo(VistaVuelo2 vista) {
		super();
		this.vista = vista;
		contVuelo = new ControladorVuelo();
		contAeropuerto = new ControladorAeropuerto();
		contLA = new ControladorLineaAerea();
		contPais = new ControladorPais();
		contProvincia = new ControladorProvincia();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
	//Alta	
		if(e.getSource()==vista.btnAgregar) {
			try {
			//Obtiene los valores de los campos	
				Integer cantidad_asientos = Integer.parseInt(vista.tf_cantidadAsientos.getText());
				String nombre_aerop_llegada = (String) vista.comboAeropuerto_llegada.getSelectedItem();
				String nombre_aerop_salida = (String) vista.comboAeropuerto_Salida.getSelectedItem();
				String fecha_salida = vista.tf_fechaSalida.getText();
				String fecha_llegada = vista.tf_fecha_llegada.getText();
				String tiempo_vuelo = vista.tf_tiempo_vuelo.getText();
				String nombre_aerolinea = (String) vista.combo_aerolinea.getSelectedItem();
				
			//Forma el número de vuelo mediante el id y el nombre de la aerolínea	
				Integer id_vuelo = contVuelo.obtenerUltimoId()+1;
				
				String numero_vuelo = formarNumeroVuelo(nombre_aerolinea,id_vuelo); 
				
			//Obtiene los aeropuertos y la aerolínea mediante sus ids	
				Aeropuerto aeropuerto_salida=contAeropuerto.consultaPorCodigo(nombre_aerop_salida);
				Aeropuerto aeropuerto_llegada = contAeropuerto.consultaPorCodigo(nombre_aerop_llegada);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				Vuelo vuelo = new Vuelo(numero_vuelo, cantidad_asientos, fecha_llegada, fecha_salida, tiempo_vuelo,aeropuerto_llegada, aeropuerto_salida, aerolinea);
				vista.lblNroVuelo.setText(numero_vuelo);
				
				if(contVuelo.altaVuelo(vuelo)) {
					JOptionPane.showMessageDialog(null, "Vuelo agregado!", "Alta de vuelos", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al realizar la operación", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
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
				Integer id = Integer.parseInt(vista.tf_Id.getText());
				Vuelo vuelo = contVuelo.consultarVuelo(id);
				
				Aerolinea aerolinea = contLA.consultarLineaAerea((vuelo.getAerolinea().getId_aeroLinea().toString()));
				vuelo.setAerolinea(aerolinea);
				
				Aeropuerto aeropSalida = contAeropuerto.consultarAeropuerto(vuelo.getAeropuertoSalida().getId_Aeropuerto());
				aeropSalida.setPais(contPais.consultaPorID(aeropSalida.getPais().getId_pais()));
				aeropSalida.setProvincia(contProvincia.consultarProvincia(aeropSalida.getProvincia().getId_provincia().toString()));
				
				Aeropuerto aeropLlegada = contAeropuerto.consultarAeropuerto(vuelo.getAeropuertoLlegada().getId_Aeropuerto());
				aeropLlegada.setPais(contPais.consultaPorID(aeropLlegada.getPais().getId_pais()));
				aeropLlegada.setProvincia(contProvincia.consultarProvincia(aeropLlegada.getProvincia().getId_provincia().toString()));
				
				vuelo.setAeropuertoSalida(aeropSalida);
				vuelo.setAeropuertoLlegada(aeropLlegada);
				
			//Setea los campos con los datos del vuelo consultado	
				vista.lblNroVuelo.setText(vuelo.getNumero());
				vista.tf_cantidadAsientos.setText(vuelo.getCantidadAsientos().toString());
				vista.tf_fechaSalida.setText(vuelo.getFechaSalida());
				vista.tf_fecha_llegada.setText(vuelo.getFechaLlegada());
				vista.tf_tiempo_vuelo.setText(vuelo.getTiempoVuelo());
				vista.combo_aerolinea.setSelectedItem(vuelo.getAerolinea().getNombre());
				vista.comboAeropuerto_Salida.setSelectedItem(vuelo.getAeropuertoSalida().getIdentificacion());
				vista.comboAeropuerto_llegada.setSelectedItem(vuelo.getAeropuertoLlegada().getIdentificacion());
				
				vista.textArea_resultado.setText(vuelo.toString());
				
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
				Integer id = Integer.parseInt(vista.tf_Id.getText());
				String numero_vuelo = vista.lblNroVuelo.getText();
				Integer cantidad_asientos = Integer.parseInt(vista.tf_cantidadAsientos.getText());
				String nombre_aerop_llegada = (String) vista.comboAeropuerto_llegada.getSelectedItem();
				String nombre_aerop_salida = (String) vista.comboAeropuerto_Salida.getSelectedItem();
				String fecha_salida = vista.tf_fechaSalida.getText();
				String fecha_llegada = vista.tf_fecha_llegada.getText();
				String tiempo_vuelo = vista.tf_tiempo_vuelo.getText();
				String nombre_aerolinea = (String) vista.combo_aerolinea.getSelectedItem();
				
			//Se obtienen los aeropuertos y la aerolínea a través de sus códigos o nombre	
				Aeropuerto aeropuerto_salida=contAeropuerto.consultaPorCodigo(nombre_aerop_salida);
				Aeropuerto aeropuerto_llegada = contAeropuerto.consultaPorCodigo(nombre_aerop_llegada);
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				Vuelo vuelo = new Vuelo(id, numero_vuelo, cantidad_asientos, fecha_llegada, fecha_salida, tiempo_vuelo,aeropuerto_llegada, aeropuerto_salida, aerolinea);
				
				if(contVuelo.modVuelo(vuelo)) {
					JOptionPane.showMessageDialog(null, "Vuelo modificado!", "Modificación de vuelo", JOptionPane.INFORMATION_MESSAGE);
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
				int input =JOptionPane.showConfirmDialog(null, "¡Se eliminará el vuelo!", "WARNING", JOptionPane.OK_CANCEL_OPTION);
				if(input == JOptionPane.OK_OPTION) {
					if(contVuelo.bajaVuelo(vista.tf_Id.getText())) {
						JOptionPane.showMessageDialog(null, "Eliminación exitosa!", "Eliminar vuelo", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
					}
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
