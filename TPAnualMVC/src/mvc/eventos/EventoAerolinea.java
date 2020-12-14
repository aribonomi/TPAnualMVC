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
		}else if(e.getSource()==vista.btnAltaAerolinea) {
			try {	
			//Se obtienen los datos de los campos	
				String nombre = vista.textFieldNombre.getText();
				Alianza al = (Alianza) vista.comboBoxAlianza.getSelectedItem();
				Aerolinea a = new Aerolinea(nombre, al);
				
				contLA.altaLineaAerea(a);
				
			//Se obtiene la aerol�nea agregada para mostrar su id	
				Aerolinea nueva = contLA.consultaPorNombre(a.getNombre());
				
			//Se muestra por pantalla el id de la aerol�nea agregada	
				vista.lbl_idAlta.setText("ID: "+nueva.getId_aeroLinea());
			}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Los id son numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
			}	
	//Consulta	
		}else if(e.getSource()==vista.btnConsultaAerolinea) {
			try {	
			//Se consulta mediante el campo del id	
				String id = vista.ModtextFieldID.getText();
				Aerolinea a =contLA.consultarLineaAerea(id);
				
			//se setean los otros campos en	
				vista.ModtextFieldNombre.setText(a.getNombre());
				vista.ModcomboBoxAlianza.setSelectedItem(a.getAlianza());
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
				String id = vista.ModtextFieldID.getText();
				String nombre = vista.ModtextFieldNombre.getText();
				Alianza alianza = (Alianza) vista.ModcomboBoxAlianza.getSelectedItem();
				Aerolinea aerolinea = new Aerolinea(Integer.parseInt(id), nombre, alianza);
				
				contLA.modLineaAerea(aerolinea);
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que todos los campos est�n completos", "Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Compruebe que todos los campos est�n correctos", "Error", JOptionPane.ERROR_MESSAGE);
				
			}	
		//Eliminar	
		}else if(e.getSource()==vista.btnEliminarAerolinea) {
			try {	
		//Confirma la eliminaci�n	
				int input =JOptionPane.showConfirmDialog(null, "Se eliminar� la aerol�nea", "WARNING", JOptionPane.OK_CANCEL_OPTION);
				if(input == 0) {
					contLA.bajaLineaAerea(vista.ModtextFieldID.getText());
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
