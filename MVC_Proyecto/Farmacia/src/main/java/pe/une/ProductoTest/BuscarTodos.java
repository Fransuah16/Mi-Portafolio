package pe.une.ProductoTest;

import java.util.List;

import pe.une.dao.ProductoDaoImplement;
import pe.une.model.Producto;

public class BuscarTodos {

	public static void main(String[] args) {
		ProductoDaoImplement dao = new ProductoDaoImplement();
		List<Producto> lista = dao.buscarTodos();
		for (Producto pro : lista) {
			System.out.println(pro.getId_P() + " " + pro.getNombre() + " " 
		+ pro.getPrecio() + " " + pro.getMarca());
		}

	}

}
