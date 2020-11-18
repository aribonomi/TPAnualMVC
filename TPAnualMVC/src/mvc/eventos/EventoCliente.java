package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.Interfaces.DireccionDAO;
import dao.negocio.*;
import mvc.controller.*;
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
		if(e.getSource()==vista.btnAtrasMenuCliente) {
			vista.setVisible(false);
		}else if(e.getSource()==vista.btnAltaCliente) {
			
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
			String pais = (String) vista.comboBox_pais.getSelectedItem();
			Direccion d = new Direccion(calle, altura, ciudad, postal, new Provincia(provincia),  new Pais(pais));
			contDireccion.altaDireccion(d);
			
		//Teléfono
			String celular = vista.textFieldCelular.getText();
			String personal = vista.textFieldPersonal.getText();
			String laboral = vista.textFieldLaboral.getText();
			Telefono t = new Telefono(celular, personal, laboral);
			contTelefono.altaTelefono(t);
			
			
		//Pasaporte
			String numero = vista.textFieldNumPas.getText();
			String autoridad = vista.textFieldAut_emision.getText();
			String fecha_emision = vista.textField_fechaEmision.getText();
			String fecha_venc = vista.textField_vencimiento.getText();
			String pais_emision = (String) vista.comboBox_paisEmision.getSelectedItem();
			Pasaporte p = new Pasaporte(numero, autoridad, fecha_emision, fecha_venc, new Pais(pais_emision));
			contPasaporte.altaPasaporte(p);
			
		//Pasajero frecuente
			String categoria = vista.textField_CatPF.getText();
			String numeroPF = vista.textField_NumPF.getText();
			String alianza = (String) vista.comboBoxAlianza.getSelectedItem();
			String id_aerolinea = vista.textField_idAerolinea.getText();
			Aerolinea aerolinea = contLA.consultarLineaAerea(id_aerolinea);
			PasajeroFrecuente pf = new PasajeroFrecuente(categoria, numeroPF, Alianza.valueOf(alianza), aerolinea);
			contPF.altaPasajFrecuente(pf);
			
			Cliente c = new Cliente(nombre, apellido, dni, cuit, fecha_nac, email,contDireccion.obtenerUltimo(), contTelefono.obtenerUltimo(), contPasaporte.obtenerUltimo(), contPF.obtenerUltimo());
			
			contCliente.altaCliente(c);
			
		}else if(e.getSource()==this.vista.btnConsulta) {
			String id = this.vista.ConstextField_id.getText();
			Cliente c = contCliente.consultarCliente(id);
			vista.textArea_resultado.setText("Resultado: "+c.toString());
		}
		
		
	}
	
	
	
	

}
