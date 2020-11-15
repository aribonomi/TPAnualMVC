package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.negocio.Aerolinea;
import dao.negocio.Alianza;
import dao.negocio.PasajeroFrecuente;
import dao.negocio.Pasaporte;
import dao.negocio.Telefono;
import mvc.controller.ControladorCliente;
import mvc.controller.ControladorDireccion;
import mvc.controller.ControladorLineaAerea;
import mvc.controller.ControladorPasajeroFrecuente;
import mvc.controller.ControladorPasaporte;
import mvc.controller.ControladorTelefono;
import mvc.view.VistaCliente;

public class EventoCliente implements ActionListener{
	
	
	VistaCliente vista;
	ControladorCliente contCliente;
	ControladorDireccion contDireccion;
	ControladorTelefono contTelefono;
	ControladorPasaporte contPasaporte;
	ControladorPasajeroFrecuente contPF;
	ControladorLineaAerea contLA;
	
	public EventoCliente(VistaCliente vista) {
		this.vista = vista;
		contCliente = new ControladorCliente();
		contDireccion = new ControladorDireccion();
		contTelefono = new ControladorTelefono();
		contPasaporte = new ControladorPasaporte();
		contPF = new ControladorPasajeroFrecuente();
		contLA = new ControladorLineaAerea();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnAltaCliente) {
			String nombre = vista.textFieldNombre.getText();
			String apellido = vista.textFieldApellido.getText();
			String dni = vista.textFieldDni.getText();
			String cuit = vista.textFieldCuit.getText();
			String fecha_nac = vista.textFieldNacimiento.getText();
			String email = vista.textFieldEmail.getText();
			
		//Dirección	
			String calle = vista.textFieldCalle.getText();
			String altura = vista.textFieldAltura.getText();
			String ciudad = vista.textFieldCiudad.getText();
			String postal = vista.textFieldCodP.getText();
			String provincia = (String) vista.comboBox_provincia.getSelectedItem();
			
			//Agregar método de consulta a partir del nombre de la provincia para obtener su id y poder generar el objeto
			String pais = (String) vista.comboBox_pais.getSelectedItem();
			
		//Teléfono
			String celular = vista.textFieldCelular.getText();
			String personal = vista.textFieldPersonal.getText();
			String laboral = vista.textFieldLaboral.getText();
			Telefono t = new Telefono(celular, personal, laboral);
			
			
		//Pasaporte
			String numero = vista.textFieldNumPas.getText();
			String autoridad = vista.textFieldAut_emision.getText();
			String fecha_venc = vista.textField_vencimiento.getText();
			String pais_emision = (String) vista.comboBox_paisEmision.getSelectedItem();
			//Pasaporte p = new Pasaporte(numero, autoridad, fecha_venc, pais_emision);
			
		//Pasajero frecuente
			String categoria = vista.textField_CatPF.getText();
			String numeroPF = vista.textField_NumPF.getText();
			String alianza = (String) vista.comboBoxAlianza.getSelectedItem();
			String id_aerolinea = vista.textField_idAerolinea.getText();
			Aerolinea aerolinea = contLA.consultarLineaAerea(id_aerolinea);
			PasajeroFrecuente pf = new PasajeroFrecuente(categoria, numeroPF, Alianza.valueOf(alianza), aerolinea);
			
		}
		
		
	}
	
	
	
	

}
