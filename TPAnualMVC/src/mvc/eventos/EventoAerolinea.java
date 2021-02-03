package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.Aerolinea;
import dao.negocio.Alianza;
import mvc.controller.*;
import mvc.view.*;

public class EventoAerolinea implements ActionListener{

//Se llama a los controladores y la vista de la aerol�nea	
	ControladorLineaAerea contLA;
	
	VistaAerolinea vista;
	
	public EventoAerolinea(VistaAerolinea vista) {
		this.vista = vista;
		contLA = new ControladorLineaAerea();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	//Bot�n que va a hacer que desaparezca la vista de la aerol�nea	
		if(e.getSource()== vista.btnAtras) {
				vista.setVisible(false);
				
	//Alta de la aerol�nea	
		}else if(e.getSource()==vista.btnAgregar) {
			try {	
			//Se obtienen los datos de los campos	
				String nombre = vista.tf_nombre.getText();
				Alianza al = (Alianza) vista.comboAlianza.getSelectedItem();
				Aerolinea a = new Aerolinea(nombre, al);
				
				if(contLA.altaLineaAerea(a)) {
//				//Se obtiene la aerol�nea agregada para mostrar su id	
//					Aerolinea nueva = contLA.consultaPorNombre(a.getNombre());
//					
//				//Se muestra por pantalla el id de la aerol�nea agregada	
//					vista.lbl_idAlta.setText("ID: "+nueva.getId_aeroLinea());
					JOptionPane.showMessageDialog(null, "Aerol�nea agregada!", "Alta", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al agregar la aerol�nea", "Alta", JOptionPane.ERROR_MESSAGE);
				}
				
			
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que todos los campos est�n completos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que los datos est�n bien", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}	
	//Consulta	
		}else if(e.getSource()==vista.btnConsultar) {
			try {	
			//Se consulta mediante el campo del id	
				String id = vista.tf_id.getText();
				Aerolinea a =contLA.consultarLineaAerea(id);
				
			//se setean los otros campos en	
				vista.tf_nombre.setText(a.getNombre());
				vista.comboAlianza.setSelectedItem(a.getAlianza());
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que exista el id ingresado", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}	
		//Modificaci�n	
		}else if(e.getSource()==vista.btnModificar) {
			try {	
			//Se obtienen los datos de los campos y se realiza la modificaci�n		
				String id = vista.tf_id.getText();
				String nombre = vista.tf_nombre.getText();
				Alianza alianza = (Alianza) vista.comboAlianza.getSelectedItem();
				Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), nombre, alianza);
				
				if(contLA.modLineaAerea(aerolinea)) {
					JOptionPane.showMessageDialog(null, "Aerol�nea modificada!", "Modificaci�n", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al modificar", "Modificaci�n", JOptionPane.ERROR_MESSAGE);
				}
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que todos los campos est�n completos", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que todos los campos est�n correctos", "Error", JOptionPane.ERROR_MESSAGE);
				
			}	
		//Eliminar	
		}else if(e.getSource()==vista.btnEliminar) {
			try {	
		//Confirma la eliminaci�n	
				int input =JOptionPane.showConfirmDialog(null, "Se eliminar� la aerol�nea", "WARNING", JOptionPane.OK_CANCEL_OPTION);
				if(input == 0) {
					if(contLA.bajaLineaAerea(vista.tf_id.getText())) {
						JOptionPane.showMessageDialog(null, "Aerol�nea eliminada!", "Baja", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Error al eliminar", "Baja", JOptionPane.ERROR_MESSAGE);
					}
				}
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que el id ingresado exista", "Error", JOptionPane.ERROR_MESSAGE);
				
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}		
		
	}	

}
