package pe.une.ClienteTest;

import java.util.List;

import pe.une.dao.ClienteDaoImplement;
import pe.une.model.Cliente;

public class ClieBuscarTodos {

	public static void main(String[] args) {
		ClienteDaoImplement dao = new ClienteDaoImplement();
		List<Cliente> lista = dao.buscarTodos();
		for(Cliente clien: lista) {
			System.out.println(clien.getDni() + 
					" " + clien.getNombre() + " " 
					+ clien.getApellido()+" "
					+clien.getEstado() +" " + clien.getId_Venta());
		}

	}

}
