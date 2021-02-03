package mvc.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.negocio.Aerolinea;
import dao.negocio.Alianza;
import mvc.controller.*;
import mvc.view.*;

public class EventoAerolinea implements ActionListener{

//Se llama a los controladores y la vista de la aerolínea	
	ControladorLineaAerea contLA;
	
	VistaAerolinea vista;
	
	public EventoAerolinea(VistaAerolinea vista) {
		this.vista = vista;
		contLA = new ControladorLineaAerea();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	//Botón que va a hacer que desaparezca la vista de la aerolínea	
		if(e.getSource()== vista.btnAtras) {
				vista.setVisible(false);
				
	//Alta de la aerolínea	
		}else if(e.getSource()==vista.btnAgregar) {
			try {	
			//Se obtienen los datos de los campos	
				String nombre = vista.tf_nombre.getText();
				Alianza al = (Alianza) vista.comboAlianza.getSelectedItem();
				Aerolinea a = new Aerolinea(nombre, al);
				
				if(contLA.altaLineaAerea(a)) {
//				//Se obtiene la aerolínea agregada para mostrar su id	
//					Aerolinea nueva = contLA.consultaPorNombre(a.getNombre());
//					
//				//Se muestra por pantalla el id de la aerolínea agregada	
//					vista.lbl_idAlta.setText("ID: "+nueva.getId_aeroLinea());
					JOptionPane.showMessageDialog(null, "Aerolínea agregada!", "Alta", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al agregar la aerolínea", "Alta", JOptionPane.ERROR_MESSAGE);
				}
				
			
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que todos los campos estén completos", "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null,"Compruebe que los datos estén bien", "Error", JOptionPane.ERROR_MESSAGE);
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
		//Modificación	
		}else if(e.getSource()==vista.btnModificar) {
			try {	
			//Se obtienen los datos de los campos y se realiza la modificación		
				String id = vista.tf_id.getText();
				String nombre = vista.tf_nombre.getText();
				Alianza alianza = (Alianza) vista.comboAlianza.getSelectedItem();
				Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), nombre, alianza);
				
				if(contLA.modLineaAerea(aerolinea)) {
					JOptionPane.showMessageDialog(null, "Aerolínea modificada!", "Modificación", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Error al modificar", "Modificación", JOptionPane.ERROR_MESSAGE);
				}
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que todos los campos estén completos", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que todos los campos estén correctos", "Error", JOptionPane.ERROR_MESSAGE);
				
			}	
		//Eliminar	
		}else if(e.getSource()==vista.btnEliminar) {
			try {	
		//Confirma la eliminación	
				int input =JOptionPane.showConfirmDialog(null, "Se eliminará la aerolínea", "WARNING", JOptionPane.OK_CANCEL_OPTION);
				if(input == 0) {
					if(contLA.bajaLineaAerea(vista.tf_id.getText())) {
						JOptionPane.showMessageDialog(null, "Aerolínea eliminada!", "Baja", JOptionPane.INFORMATION_MESSAGE);
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
