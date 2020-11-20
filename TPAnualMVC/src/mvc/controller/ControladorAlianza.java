package mvc.controller;

import dao.negocio.Alianza;

public class ControladorAlianza {
	
	Alianza a;
	
	public ControladorAlianza() {
		
	}
	
	public Alianza getAlianza(String tipo) {
		switch (tipo) {
		case "ONEWORLD":
			return Alianza.ONEWORLD;
		case "SKYTEAM":
			return Alianza.SKYTEAM;
		case "STARALLIANCE":
			return Alianza.STARALLIANCE;
		default:
			return Alianza.ONEWORLD;
			
		}
	}
	
	

}
