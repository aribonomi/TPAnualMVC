package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.*;
import mvc.controller.*;
import mvc.view.VistaCliente2;

public class EventoCliente implements ActionListener{
	
	
//Se llama a los controladores y la vista del cliente	
	VistaCliente2 vista;
	ControladorCliente contCliente;
	ControladorDireccion contDireccion;
	ControladorTelefono contTelefono;
	ControladorPasaporte contPasaporte;
	ControladorPasajeroFrecuente contPF;
	ControladorLineaAerea contLA;
	ControladorPais contPais;
	ControladorProvincia contProvincia;
	
	public EventoCliente(VistaCliente2 vista) {
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
		if(e.getSource()==vista.btnAtras) {
			vista.setVisible(false);
		
	//Alta	
		}else if(e.getSource()==vista.btnAgregar) {
			try {
			
			//Obtiene los datos de los campos	
				String nombre = vista.tf_nombre.getText();
				String apellido = vista.tf_apellido.getText();
				String dni = vista.tf_dni.getText();
				String cuit = vista.tf_cuit.getText();
				String fecha_nac = vista.tf_fecha_nacimiento.getText();
				String email = vista.tf_email.getText();
				
			//Dirección	
				String calle = vista.tf_calle.getText();
				String altura = vista.tf_altura.getText();
				String ciudad = vista.tf_ciudad.getText();
				String postal = vista.tf_codigo_postal.getText();
				String provincia = (String) vista.comboProvincia.getSelectedItem();
				String pais = (String) vista.comboPais.getSelectedItem();
				
				
			//Chequea si se ingresó el país y la provincia mediante los campos "Otro"	
				if(provincia.equalsIgnoreCase("Internacional")) {
					if(pais.equalsIgnoreCase("Otro")) {
						contPais.altaPais(new Pais(vista.tf_otroPais.getText()));
						contProvincia.altaProv(new Provincia(vista.tf_otraProvincia.getText()));
						Pais p = contPais.consultarPais(vista.tf_otroPais.getText());
						Provincia prov = contProvincia.consultarPorNombre(vista.tf_otraProvincia.getText());
						Direccion d = new Direccion(calle, altura, ciudad, postal, prov,  p);
						contDireccion.altaDireccion(d);
					}else {
						contProvincia.altaProv(new Provincia(vista.tf_otraProvincia.getText()));
						Provincia prov = contProvincia.consultarPorNombre(vista.tf_otraProvincia.getText());
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
				String celular = vista.tf_celular.getText();
				String personal = vista.tf_personal.getText();
				String laboral = vista.tf_laboral.getText();
				Telefono t = new Telefono(celular, personal, laboral);
				contTelefono.altaTelefono(t);
				
				
			//Pasaporte
				String numero = vista.tf_numeroPasaporte.getText();
				String autoridad = vista.tf_autoridadEmision.getText();
				String fecha_emision = vista.tf_fechaEmision.getText();
				String fecha_venc = vista.tf_fechaVencimiento.getText();
				String pais_emision = (String) vista.comboPaisEmision.getSelectedItem();
				Pais paisEmision = contPais.consultarPais(pais_emision);
				Pasaporte pasaporte = new Pasaporte(numero, autoridad, fecha_emision, fecha_venc, paisEmision);
				contPasaporte.altaPasaporte(pasaporte);
				
			//Pasajero frecuente
				String categoria = vista.tf_categoria.getText();
				String numeroPF = vista.tf_numeroPF.getText();
				Alianza alianza = (Alianza) vista.comboAlianza.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboAerolinea.getSelectedItem();
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				PasajeroFrecuente pf = new PasajeroFrecuente(categoria, numeroPF, alianza, aerolinea);
				contPF.altaPasajFrecuente(pf);
				
				Cliente c = new Cliente(nombre, apellido, dni, cuit, fecha_nac, email,contDireccion.obtenerUltimo(), contTelefono.obtenerUltimo(), contPasaporte.obtenerUltimo(), contPF.obtenerUltimo());
				
			//Se realiza la alta y se muestra por pantalla el cliente ingresado	
				if(contCliente.altaCliente(c)) {
					JOptionPane.showMessageDialog(null, "Cliente agregado", "Alta de cliente", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al agregar al cliente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que estén bien todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			
			}
			
	//Consulta	
		}else if(e.getSource()==this.vista.btnConsultar) {
			try {
				//Se consulta el cliente mediante el campo id	
				Integer id = Integer.parseInt(this.vista.tf_id.getText());
				
				Cliente c = contCliente.consultaPorId(id);
				
			//Se consultan los objetos contenidos dentro del cliente mediante el cliente consultado	
				Direccion d = contDireccion.consultar(c.getdireccion().getId_direccion().toString());
				d.setPais(contPais.consultaPorID(d.getPais().getId_pais()));
				d.setProvincia(contProvincia.consultarProvincia(d.getProvincia().getId_provincia().toString()));
				
				Telefono t = contTelefono.consultarTelefono(c.gettelefono().getId_Telefono().toString());
				
				Pasaporte p = contPasaporte.consultarPasaporte(c.getpasaporte().getId_Pasaporte().toString());
				p.setPaisEmision(contPais.consultaPorID(p.getPaisEmision().getId_pais()));
				
				PasajeroFrecuente pf = contPF.consultarPasajeroFrecuente(c.getpasajeroFrecuente().getId_pasajeroFrecuente().toString());
				
				Aerolinea a = contLA.consultarLineaAerea(pf.getAerolinea().getId_aeroLinea().toString());
				
				c.setId_direccion(d);
				c.setId_telefono(t);
				c.setId_pasaporte(p);
				c.setpasajeroFrecuente(pf);
				c.getpasajeroFrecuente().setAerolinea(a);

				
			//Se setean los datos del cliente mediante las consultas hechas	
				vista.tf_nombre.setText(c.getNombre());
				vista.tf_apellido.setText(c.getApellido());
				vista.tf_dni.setText(c.getDni());
				vista.tf_cuit.setText(c.getCuit_cuil());
				vista.tf_fecha_nacimiento.setText(c.getFecha_nacimiento());
				vista.tf_email.setText(c.getEmail());
				
				vista.lbl_id_direccion.setText(c.getdireccion().getId_direccion().toString());
				vista.tf_calle.setText(d.getCalle());
				vista.tf_altura.setText(d.getAltura());
				vista.tf_ciudad.setText(d.getCiudad());
				vista.tf_codigo_postal.setText(d.getCodigoPostal());
				vista.comboProvincia.setSelectedItem(d.getProvincia().getNombreProvincia());
				vista.comboPais.setSelectedItem(d.getPais().getNombrePais());
				
				vista.lbl_id_telefono.setText(t.getId_Telefono().toString());
				vista.tf_celular.setText(t.getCelular());
				vista.tf_personal.setText(t.getPersona());
				vista.tf_laboral.setText(t.getLaboral());
				
				vista.lbl_id_pasaporte.setText(p.getId_Pasaporte().toString());
				vista.tf_numeroPasaporte.setText(p.getNumero());
				vista.tf_autoridadEmision.setText(p.getAutoridadEmision());
				vista.tf_fechaEmision.setText(p.getFechaEmision());
				vista.tf_fechaVencimiento.setText(p.getFechaVencimiento());
				vista.comboPaisEmision.setSelectedItem(p.getPaisEmision().getNombrePais());
				
				vista.lbl_id_pasajeroFrecuente.setText(pf.getId_pasajeroFrecuente().toString());
				vista.tf_categoria.setText(pf.getCategoria());
				vista.tf_numeroPF.setText(pf.getNumero());
				vista.comboAlianza.setSelectedItem(pf.getAlianza());
				vista.comboAerolinea.setSelectedItem(a.getNombre());
				
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que exista el id ingresado", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		
			
			
	//Eliminación	
		}else if(e.getSource()==vista.btnEliminar) {
		//Confirma la eliminación	
			try {
				int resultado = JOptionPane.showConfirmDialog(null, "Se eliminará el registro", "Warning", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(resultado == 0) {
					
				//Se dan de baja todos los datos del cliente						
					contDireccion.bajaDireccion(vista.lbl_id_direccion.getText());
					contTelefono.bajaTelefono(vista.lbl_id_telefono.getText());
					contPasaporte.bajaPasaporte(vista.lbl_id_pasaporte.getText());
					contPF.bajaPasajFrecuente(vista.lbl_id_pasajeroFrecuente.getText());
					
					if(contCliente.bajaCliente(vista.tf_id.getText())) {
						JOptionPane.showMessageDialog(null, "Cliente eliminado", "Baja cliente", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
					}
	
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
		}else if(e.getSource()==vista.btnModificar) {
			try {
				
			//Obtiene los campos completados en la consulta y realiza la modificación	
				Integer id = Integer.parseInt(vista.tf_id.getText());
				String nombre = vista.tf_nombre.getText();
				String apellido = vista.tf_apellido.getText();
				String dni = vista.tf_dni.getText();
				String cuit = vista.tf_cuit.getText();
				String fecha_nac = vista.tf_fecha_nacimiento.getText();
				String email = vista.tf_email.getText();
				
			//Dirección	
				Direccion d;
				Integer id_direccion = Integer.parseInt(vista.lbl_id_direccion.getText());
				String calle = vista.tf_calle.getText();
				String altura = vista.tf_altura.getText();
				String ciudad = vista.tf_ciudad.getText();
				String postal = vista.tf_codigo_postal.getText();
				String provincia = (String) vista.comboProvincia.getSelectedItem();
				String pais = (String) vista.comboPais.getSelectedItem();
				
				
			//Chequea si se ingresó el país y la provincia mediante los campos "Otro"	
				if(provincia.equalsIgnoreCase("Internacional")) {
					if(pais.equalsIgnoreCase("Otro")) {
						contPais.altaPais(new Pais(vista.tf_otroPais.getText()));
						contProvincia.altaProv(new Provincia(vista.tf_otraProvincia.getText()));
						Pais p = contPais.consultarPais(vista.tf_otroPais.getText());
						Provincia prov = contProvincia.consultarPorNombre(vista.tf_otraProvincia.getText());
						d = new Direccion(id_direccion, calle, altura, ciudad, postal, prov,  p);
						contDireccion.modDireccion(d);
					}else {
						contProvincia.altaProv(new Provincia(vista.tf_otraProvincia.getText()));
						Provincia prov = contProvincia.consultarPorNombre(vista.tf_otraProvincia.getText());
						Pais p = contPais.consultarPais(pais);
						d = new Direccion(id_direccion, calle, altura, ciudad, postal, prov,  p);
						contDireccion.modDireccion(d);
					}	
				}else {
					Provincia prov = contProvincia.consultarPorNombre(provincia);
					Pais p = contPais.consultarPais(pais);
					
					d = new Direccion(id_direccion, calle, altura, ciudad, postal, prov,  p);
					contDireccion.modDireccion(d);
				}	
				
				
			//Teléfono
				Integer id_telefono = Integer.parseInt(vista.lbl_id_telefono.getText());
				String celular = vista.tf_celular.getText();
				String personal = vista.tf_personal.getText();
				String laboral = vista.tf_laboral.getText();
				Telefono t = new Telefono(id_telefono, celular, personal, laboral);
				contTelefono.modTelefono(t);
				
				
			//Pasaporte
				Integer id_pasaporte = Integer.parseInt(vista.lbl_id_pasaporte.getText());
				String numero = vista.tf_numeroPasaporte.getText();
				String autoridad = vista.tf_autoridadEmision.getText();
				String fecha_emision = vista.tf_fechaEmision.getText();
				String fecha_venc = vista.tf_fechaVencimiento.getText();
				String pais_emision = (String) vista.comboPaisEmision.getSelectedItem();
				Pais paisEmision = contPais.consultarPais(pais_emision);
				Pasaporte pasaporte = new Pasaporte(id_pasaporte, numero, autoridad, fecha_emision, fecha_venc, paisEmision);
				contPasaporte.modPasaporte(pasaporte);
				
			//Pasajero frecuente
				Integer id_pf = Integer.parseInt(vista.lbl_id_pasajeroFrecuente.getText());
				String categoria = vista.tf_categoria.getText();
				String numeroPF = vista.tf_numeroPF.getText();
				Alianza alianza = (Alianza) vista.comboAlianza.getSelectedItem();
				String nombre_aerolinea = (String) vista.comboAerolinea.getSelectedItem();
				Aerolinea aerolinea = contLA.consultaPorNombre(nombre_aerolinea);
				PasajeroFrecuente pf = new PasajeroFrecuente(id_pf, categoria, numeroPF, alianza, aerolinea);
				contPF.modPasajFrecuente(pf);
				
				Cliente c = new Cliente(id, nombre, apellido, dni, cuit, fecha_nac, email, d, t, pasaporte, pf);
				
				if(contCliente.modificarCliente(c)) {
					JOptionPane.showMessageDialog(null, "Cliente modificado", "Modificación de cliente", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al modificar al cliente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
								
			}catch(NullPointerException np) {
				JOptionPane.showMessageDialog(null, "Compruebe que no queden campos por completar", "Error", JOptionPane.ERROR_MESSAGE);
				np.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que estén bien todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			
			}
		}
		
		
	}
	
	
	
	

}
