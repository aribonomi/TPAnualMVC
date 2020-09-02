package mvc.main;

import java.util.Date;

import dao.Cliente.Cliente;
import dao.Cliente.Direccion;
import dao.Cliente.PasajeroFrecuente;
import dao.Cliente.Pasaporte;
import dao.Cliente.Telefono;
import dao.Vuelo.Aerolinea;
import dao.Vuelo.Pais;
import dao.Vuelo.Provincia;
import mvc.controller.VerificarEdad;
import mvc.view.MenuPrincipal;
import mvc.view.MenuPrincipalSwing;

public class Main {
	
	public static void main(String[] args) {
	
	Pais _pais = new Pais("24", "Argentina");
	Provincia _provincia = new Provincia("234233", "Buenos Aires");
	
	Date d1 = new Date(3);
	
	Pasaporte _pasaporte = new Pasaporte(32, "11122233", "Sargento Chaja", d1, d1, _pais);
	
	Aerolinea _aerolinea = new Aerolinea(32, "Emirates", null, null);
	
	PasajeroFrecuente _pf = new PasajeroFrecuente(45, "MuyFrecuente", "4442233232", null, _aerolinea);
	
	Telefono _telefono = new Telefono(3342332, "Ariel", "03484333222", "333211132");
	
	Direccion _direccion = new Direccion(234232, "Calle Wala", "1402", "Cidney", "20883874", _provincia, _pais);
	
	Cliente _cliente = new Cliente("4", "Ariel", "Bonomi", "40640652", "13406406523",
			"24/2", "bonomiariel1@gmail.com", _direccion, _telefono, 
			_pasaporte, _pf);
	
	
//	VerificarEdad.verificarEdad(_cliente);
//	MenuPrincipal.menuPrincipal();

	MenuPrincipalSwing.JMenuPrincipal();
	
	}
	
	
	
}
