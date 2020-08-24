package mvc.controller;

import dao.Cliente.Cliente;

public class VerificarEdad {
	
	public static void verificarEdad(Cliente cliente) {
		
		int i = Integer. parseInt(cliente.getDni());
		if(i<22000000) {
			System.out.println("Es Menor a 18");
		}
		else {
			System.out.println("Es Mayor a 18");
		}
		
	}

}
