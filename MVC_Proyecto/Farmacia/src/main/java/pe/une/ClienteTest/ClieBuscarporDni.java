package pe.une.ClienteTest;

import pe.une.dao.ClienteDaoImplement;
import pe.une.model.Cliente;

public class ClieBuscarporDni {

	public static void main(String[] args) {
		ClienteDaoImplement dao = new ClienteDaoImplement();
		Cliente clien = dao.buscarPorDni("44443333");
		if(clien.getDni()!= null) {
			System.out.println("Cliente Encontrado");
			System.out.println(clien.getDni()+" "+clien.getNombre()+" "+clien.getApellido()+" "+clien.getId_Venta());

		}else {
			System.out.println("Cliente no encontrado");
		}
		
		
	}

}
