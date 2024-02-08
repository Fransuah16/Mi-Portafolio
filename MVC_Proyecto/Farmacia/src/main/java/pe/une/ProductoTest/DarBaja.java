package pe.une.ProductoTest;

import java.util.Scanner;

import pe.une.dao.ProductoDaoImplement;

public class DarBaja {

	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		ProductoDaoImplement dao = new ProductoDaoImplement();
		System.out.println("Ingrese Codigo del Producto a dar Baja");
		String code = Leer.next();
		dao.darBaja(code);
		System.out.println("Proceso Terminado");
		
	}

}
