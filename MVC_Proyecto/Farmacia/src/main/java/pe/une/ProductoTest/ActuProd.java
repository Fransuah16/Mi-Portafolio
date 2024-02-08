package pe.une.ProductoTest;

import java.util.Scanner;

import pe.une.dao.ProductoDaoImplement;
import pe.une.model.Producto;

public class ActuProd {

	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		ProductoDaoImplement dao = new ProductoDaoImplement();
		System.out.println("Actualizacion de un porducto Registrado");
		System.out.println("Ingrese Codigo");
		String cod = Leer.next();
		System.out.println("Ingrese Nombre:");
		String nombre = Leer.next();
		System.out.println("Ingrese el Precio:");
		String prec = Leer.next();
		System.out.println("Ingrese el Marca:");
		String marka = Leer.next();
		System.out.println("Ingrese la Estado");
		int estado = Leer.nextInt();
		Producto pro = new Producto(cod,nombre,prec,marka,estado);
		dao.actualizar(pro);
		System.out.println("Producto Actualizado");
	}

}
