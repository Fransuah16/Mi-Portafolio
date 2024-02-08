package pe.une.ProductoTest;

import pe.une.dao.ProductoDaoImplement;
import pe.une.model.Producto;

public class BuscarporCodigo {

	public static void main(String[] args) {
		ProductoDaoImplement dao = new ProductoDaoImplement();
		Producto pro = dao.buscarPorCodigo("123");
		System.out.println("Producto Encontrado");
		
		System.out.println(pro.getId_P()+" "+pro.getNombre()+" "
		+pro.getMarca()+" "+pro.getPrecio());
	}

}
