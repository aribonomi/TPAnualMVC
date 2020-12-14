package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.Interfaces.DireccionDAO;
import dao.negocio.*;
import mvc.controller.*;
import mvc.view.VistaCliente;

public class EventoCliente implements ActionListener{
	
	
//Se llama a los controladores y la vista del cliente	
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
	//Botón atras para que desaparezca la vista actual	
		if(e.getSource()==vista.btnAtrasMenuCliente) {
			vista.setVisible(false);
		
	//Alta	
		}else if(e.getSource()==vista.btnAltaCliente) {
			try {
			
			//Obtiene los datos de los campos	
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
				
				
			//Chequea si se ingresó el país y la provincia mediante los campos "Otro"	
				if(provincia.equalsIgnoreCase("Internacional")) {
					if(pais.equalsIgnoreCase("Otro")) {
						contPais.altaPais(new Pais(vista.textFieldOtroPais.getText()));
						contProvincia.altaProv(new Provincia(vista.textFieldProvincia.getText()));
						Pais p = contPais.consultarPais(vista.textFieldOtroPais.getText());
						Provincia prov = contProvincia.consultarPorNombre(vista.textFieldProvincia.getText());
						Direccion d = new Direccion(calle, altura, ciudad, postal, prov,  p);
						contDireccion.altaDireccion(d);
					}else {
						contProvincia.altaProv(new Provincia(vista.textFieldProvincia.getText()));
						Provincia prov = contProvincia.consultarPorNombre(vista.textFieldProvincia.getText());
						Pais p = contPais.consultarPais(pais);
						Direccion d = new Direccion(calle, altura, ciudad, postal, prov,  p);
						contDireccion.altaDireccion(d);
					}	
				}else {
					Provincia prov = contProvincia.consultarPorNombre(provincia);
					Pais p = contPais.consultarPais(pais);
					
					Direccion d = new Direccion(calle, altura, ciudad, postal, prov,  p);
					contDireccion.altaDireccion(d);
				}	
				
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
				String nombre_aerolinea = (String) vista.comboBoxAerolinea.getSelectedItem();
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				PasajeroFrecuente pf = new PasajeroFrecuente(categoria, numeroPF, alianza, aerolinea);
				contPF.altaPasajFrecuente(pf);
				
				Cliente c = new Cliente(nombre, apellido, dni, cuit, fecha_nac, email,contDireccion.obtenerUltimo(), contTelefono.obtenerUltimo(), contPasaporte.obtenerUltimo(), contPF.obtenerUltimo());
				
			//Se realiza la alta y se muestra por pantalla el cliente ingresado	
				contCliente.altaCliente(c);
				
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que estén bien todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			
			}
			
	//Consulta	
		}else if(e.getSource()==this.vista.btnConsultaMod) {
			try {
				//Se consulta el cliente mediante el campo id	
				Integer id = Integer.parseInt(this.vista.ModtextFieldID.getText());
				
				Cliente c = contCliente.consultaPorId(id);

			//Se consultan los objetos contenidos dentro del cliente mediante el cliente consultado	
				Direccion d = contDireccion.consultar(c.getdireccion().getId_direccion().toString());
				Telefono t = contTelefono.consultarTelefono(c.gettelefono().getId_Telefono().toString());
				Pasaporte p = contPasaporte.consultarPasaporte(c.getpasaporte().getId_Pasaporte().toString());
				PasajeroFrecuente pf = contPF.consultarPasajeroFrecuente(c.getpasajeroFrecuente().getId_pasajeroFrecuente().toString());
				Aerolinea a = contLA.consultarLineaAerea(pf.getAerolinea().getId_aeroLinea().toString());
				
			//Se setean los datos del cliente mediante las consultas hechas	
				vista.ModtextFieldNombre.setText(c.getNombre());
				vista.ModtextFieldApellido.setText(c.getApellido());
				vista.ModtextFieldDni.setText(c.getDni());
				vista.ModtextFieldCuit.setText(c.getCuit_cuil());
				vista.ModtextFieldNacimiento.setText(c.getFecha_nacimiento());
				vista.ModtextFieldEmail.setText(c.getEmail());
				
				vista.lbl_idDireccion.setText(d.getId_direccion().toString());
				vista.ModtextFieldCalle.setText(d.getCalle());
				vista.ModtextFieldAltura.setText(d.getAltura());
				vista.ModtextFieldCiudad.setText(d.getCiudad());
				vista.ModtextFieldCodP.setText(d.getCodigoPostal());
				vista.ModcomboBox_provincia.setSelectedItem(d.getProvincia().getNombreProvincia());
				vista.ModcomboBox_pais.setSelectedItem(d.getPais().getNombrePais());
				
				vista.lbl_idTelefono.setText(t.getId_Telefono().toString());
				vista.ModtextFieldCelular.setText(t.getCelular());
				vista.ModtextFieldPersonal.setText(t.getPersona());
				vista.ModtextFieldLaboral.setText(t.getLaboral());
				
				vista.lbl_idPasaporte.setText(p.getId_Pasaporte().toString());
				vista.ModtextFieldNumero.setText(p.getNumero());
				vista.ModtextField_emision.setText(p.getAutoridadEmision());
				vista.ModtextFieldFechaEmision.setText(p.getFechaEmision());
				vista.ModtextField_vencimiento.setText(p.getFechaVencimiento());
				vista.ModcomboBox_paisEmision.setSelectedItem(p.getPaisEmision().getNombrePais());
				
				vista.lbl_idPF.setText(pf.getId_pasajeroFrecuente().toString());
				vista.ModtextFieldCategoria.setText(pf.getCategoria());
				vista.ModtextFieldNumeroPF.setText(pf.getNumero());
				vista.ModcomboBoxAlianza.setSelectedItem(pf.getAlianza());
				vista.ModcomboBoxAerolinea.setSelectedItem(a.getNombre());
				
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que exista el id ingresado", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		
			
			
	//Eliminación	
		}else if(e.getSource()==vista.btnEliminarCliente) {
		//Confirma la eliminación	
			try {
				int resultado = JOptionPane.showConfirmDialog(null, "Se eliminará el registro", "Warning", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(resultado == 0) {
					
				//Se dan de baja todos los datos del cliente						
					contDireccion.bajaDireccion(vista.lbl_idDireccion.getText());
					contTelefono.bajaTelefono(vista.lbl_idTelefono.getText());
					contPasaporte.bajaPasaporte(vista.lbl_idPasaporte.getText());
					contPF.bajaPasajFrecuente(vista.lbl_idPF.getText());
					
					contCliente.bajaCliente(vista.ModtextFieldID.getText());
	
				}
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que exista el id ingresado", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error en la base de datos");
				ex.printStackTrace();
			}
	
	//Modificación		
		}else if(e.getSource()==vista.btnModificarCliente) {
			try {
				
			//Obtiene los campos completados en la consulta y realiza la modificación	
				Integer id = Integer.parseInt(vista.ModtextFieldID.getText());
				String nombre = vista.ModtextFieldNombre.getText();
				String apellido = vista.ModtextFieldApellido.getText();
				String dni = vista.ModtextFieldDni.getText();
				String cuit = vista.ModtextFieldCuit.getText();
				String fecha_nac = vista.ModtextFieldNacimiento.getText();
				String email = vista.ModtextFieldEmail.getText();
				
			//Dirección	
				Integer id_direccion = Integer.parseInt(vista.lbl_idDireccion.getText());
				String calle = vista.ModtextFieldCalle.getText();
				String altura = vista.ModtextFieldAltura.getText();
				String ciudad = vista.ModtextFieldCiudad.getText();
				String postal = vista.ModtextFieldCodP.getText();
				String provincia = (String) vista.ModcomboBox_provincia.getSelectedItem();
				String pais = (String) vista.ModcomboBox_pais.getSelectedItem();
				
				Pais p = contPais.consultarPais(pais);
				Provincia prov = contProvincia.consultarPorNombre(provincia);
				
				Direccion d = new Direccion(id_direccion, calle, altura, ciudad, postal, prov,  p);
				contDireccion.modDireccion(d);		
				
				
			//Teléfono
				Integer id_telefono = Integer.parseInt(vista.lbl_idTelefono.getText());
				String celular = vista.ModtextFieldCelular.getText();
				String personal = vista.ModtextFieldPersonal.getText();
				String laboral = vista.ModtextFieldLaboral.getText();
				Telefono t = new Telefono(id_telefono,celular, personal, laboral);
				contTelefono.modTelefono(t);
				
				
			//Pasaporte
				Integer id_pasaporte = Integer.parseInt(vista.lbl_idPasaporte.getText());
				String numero = vista.ModtextFieldNumero.getText();
				String autoridad = vista.ModtextField_emision.getText();
				String fecha_emision = vista.ModtextFieldFechaEmision.getText();
				String fecha_venc = vista.ModtextField_vencimiento.getText();
				String pais_emision = (String) vista.ModcomboBox_paisEmision.getSelectedItem();
				Pais paisEmision = contPais.consultarPais(pais_emision);
				Pasaporte pasaporte = new Pasaporte(id_pasaporte,numero, autoridad, fecha_emision, fecha_venc, paisEmision);
				contPasaporte.modPasaporte(pasaporte);
				
			//Pasajero frecuente
				Integer id_pf = Integer.parseInt(vista.lbl_idPF.getText());
				String categoria = vista.ModtextFieldCategoria.getText();
				String numeroPF = vista.ModtextFieldNumeroPF.getText();
				Alianza alianza = (Alianza) vista.ModcomboBoxAlianza.getSelectedItem();
				String nombre_aerolinea = vista.ModcomboBoxAerolinea.getSelectedItem().toString();
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				PasajeroFrecuente pf = new PasajeroFrecuente(id_pf,categoria, numeroPF, alianza, aerolinea);
				contPF.modPasajFrecuente(pf);
				
				Cliente c = new Cliente(id, nombre, apellido, dni, cuit, fecha_nac, email, d, t, pasaporte, pf);
				
				contCliente.modificarCliente(c);
				
				JOptionPane.showMessageDialog(null, c.toString(), "Datos del cliente", JOptionPane.INFORMATION_MESSAGE);
				
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que estén bien todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			
			}
		}
		
		
	}
	
	
	
	

}
