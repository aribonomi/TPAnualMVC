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
	ControladorPais contPais;
	ControladorProvincia contProvincia;
	
	public EventoCliente(VistaCliente vista) {
		this.vista = vista;
		contCliente = new ControladorCliente();
		contDireccion = new ControladorDireccion();
		contTelefono = new ControladorTelefono();
		contPasaporte = new ControladorPasaporte();
		contPF = new ControladorPasajeroFrecuente();
		contLA = new ControladorLineaAerea();
		contPais = new ControladorPais();
		contProvincia = new ControladorProvincia();
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
				Provincia prov = contProvincia.consultarProvincia(provincia);
				String pais = (String) vista.comboBox_pais.getSelectedItem();
				Pais p = contPais.consultarPais(pais);
				Direccion d = new Direccion(calle, altura, ciudad, postal, prov,  p);
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
				Pais paisEmision = contPais.consultarPais(pais_emision);
				Pasaporte pasaporte = new Pasaporte(numero, autoridad, fecha_emision, fecha_venc, paisEmision);
				contPasaporte.altaPasaporte(pasaporte);
				
			//Pasajero frecuente
				String categoria = vista.textField_CatPF.getText();
				String numeroPF = vista.textField_NumPF.getText();
				Alianza alianza = (Alianza) vista.comboBoxAlianza.getSelectedItem();
				String id_aerolinea = vista.textField_idAerolinea.getText();
				Aerolinea aerolinea = contLA.consultarLineaAerea(id_aerolinea);
				PasajeroFrecuente pf = new PasajeroFrecuente(categoria, numeroPF, alianza, aerolinea);
				contPF.altaPasajFrecuente(pf);
				
				Cliente c = new Cliente(nombre, apellido, dni, cuit, fecha_nac, email,contDireccion.obtenerUltimo(), contTelefono.obtenerUltimo(), contPasaporte.obtenerUltimo(), contPF.obtenerUltimo());
				
				contCliente.altaCliente(c);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que estén bien todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			
			}
			
		}else if(e.getSource()==this.vista.btnConsultaMod) {
			String id = this.vista.ModtextFieldID.getText();
			
			Cliente c = contCliente.consultarCliente(id);
		//Me da null porque el cliente consultado tiene esos objetos en null	
			Direccion d = contDireccion.consultar(c.getdireccion().getId_direccion().toString());
			Telefono t = contTelefono.consultarTelefono(c.gettelefono().getId_Telefono().toString());
			Pasaporte p = contPasaporte.consultarPasaporte(c.getpasaporte().getId_Pasaporte().toString());
			PasajeroFrecuente pf = contPF.consultarPasajeroFrecuente(c.getpasajeroFrecuente().getId_pasajeroFrecuente().toString());
			Aerolinea a = contLA.consultarLineaAerea(pf.getAerolinea().getId_aeroLinea().toString());
			
			vista.ModtextFieldNombre.setText(c.getNombre());
			vista.ModtextFieldApellido.setText(c.getApellido());
			vista.ModtextFieldDni.setText(c.getDni());
			vista.ModtextFieldCuit.setText(c.getCuit_cuil());
			vista.ModtextFieldNacimiento.setText(c.getFecha_nacimiento());
			vista.ModtextFieldEmail.setText(c.getEmail());
			
			vista.ModtextFieldCalle.setText(d.getCalle());
			vista.ModtextFieldAltura.setText(d.getAltura());
			vista.ModtextFieldCiudad.setText(d.getCiudad());
			vista.ModtextFieldCodP.setText(d.getCodigoPostal());
			vista.comboBox_provincia.setSelectedItem(d.getPais().getNombrePais());
			vista.comboBox_pais.setSelectedItem(d.getProvincia().getNombreProvincia());
			
			vista.ModtextFieldCelular.setText(t.getCelular());
			vista.ModtextFieldPersonal.setText(t.getPersona());
			vista.ModtextFieldLaboral.setText(t.getLaboral());
			
			vista.ModtextFieldNumero.setText(p.getNumero());
			vista.ModtextField_emision.setText(p.getAutoridadEmision());
			vista.ModtextFieldFechaEmision.setText(p.getFechaEmision());
			vista.ModtextField_vencimiento.setText(p.getFechaVencimiento());
			vista.ModcomboBox_paisEmision.setSelectedItem(p.getPaisEmision().getNombrePais());
			
			vista.ModtextFieldCategoria.setText(pf.getCategoria());
			vista.ModtextFieldNumeroPF.setText(pf.getNumero());
			vista.comboBoxAlianza.setSelectedItem(pf.getAlianza());
			vista.ModtextField_idAerolinea.setText(a.getId_aeroLinea().toString());
			
			
		}else if(e.getSource()==vista.btnEliminarCliente) {
			
			int resultado = JOptionPane.showConfirmDialog(null, "Se eliminará el registro", "Warning", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
			if(resultado == 0) {
				Cliente c = contCliente.consultarCliente(vista.ModtextFieldID.getText());
					Direccion d = contDireccion.consultar(c.getdireccion().getId_direccion().toString());
					Telefono t = contTelefono.consultarTelefono(c.gettelefono().getId_Telefono().toString());
					Pasaporte p = contPasaporte.consultarPasaporte(c.getpasaporte().getId_Pasaporte().toString());
					PasajeroFrecuente pf = contPF.consultarPasajeroFrecuente(c.getpasajeroFrecuente().getId_pasajeroFrecuente().toString());
					Aerolinea a = contLA.consultarLineaAerea(pf.getAerolinea().getId_aeroLinea().toString());
					
					contDireccion.bajaDireccion(d.getId_direccion().toString());
					contTelefono.bajaTelefono(t.getId_Telefono().toString());
					contPasaporte.bajaPasaporte(t.getId_Telefono().toString());
					contPF.bajaPasajFrecuente(pf.getId_pasajeroFrecuente().toString());
					contCliente.bajaCliente(c.getId_cliente().toString());

			}
		}
		
		
	}
	
	
	
	

}
