package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			try {
				
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
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que estén bien todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}else if(e.getSource()==this.vista.btnConsultaMod) {
			String id = this.vista.ModtextFieldID.getText();
			Cliente c = contCliente.consultarCliente(id);

			vista.ModtextFieldNombre.setText(c.getNombre());
			vista.ModtextFieldApellido.setText(c.getApellido());
			vista.ModtextFieldDni.setText(c.getDni());
			vista.ModtextFieldCuit.setText(c.getCuit_cuil());
			vista.ModtextFieldNacimiento.setText(c.getFecha_nacimiento());
			vista.ModtextFieldEmail.setText(c.getEmail());
			
			vista.ModtextFieldCalle.setText(c.getdireccion().getCalle());
			vista.ModtextFieldAltura.setText(c.getdireccion().getAltura());
			vista.ModtextFieldCiudad.setText(c.getdireccion().getCiudad());
			vista.ModtextFieldCodP.setText(c.getdireccion().getCodigoPostal());
			vista.comboBox_provincia.setSelectedItem((String)c.getdireccion().getPais().getNombrePais());
			vista.comboBox_pais.setSelectedItem((String)c.getdireccion().getProvincia().getNombreProvincia());
			
			vista.ModtextFieldCelular.setText(c.gettelefono().getCelular());
			vista.ModtextFieldPersonal.setText(c.gettelefono().getPersona());
			vista.ModtextFieldLaboral.setText(c.gettelefono().getLaboral());
			
			vista.ModtextFieldNumero.setText(c.getpasaporte().getNumero());
			vista.ModtextField_emision.setText(c.getpasaporte().getAutoridadEmision());
			vista.ModtextFieldFechaEmision.setText(c.getpasaporte().getFechaEmision());
			vista.ModtextField_vencimiento.setText(c.getpasaporte().getFechaVencimiento());
			vista.ModcomboBox_paisEmision.setSelectedItem((String)c.getpasaporte().getPaisEmision().getNombrePais());
			
			vista.ModtextFieldCategoria.setText(c.getpasajeroFrecuente().getCategoria());
			vista.ModtextFieldNumeroPF.setText(c.getpasajeroFrecuente().getNumero());
			vista.comboBoxAlianza.setSelectedItem(c.getpasajeroFrecuente().getAlianza());
			vista.ModtextField_idAerolinea.setText(c.getpasajeroFrecuente().getAerolinea().getId_aeroLinea().toString());
			
			
		}
		
		
	}
	
	
	
	

}
