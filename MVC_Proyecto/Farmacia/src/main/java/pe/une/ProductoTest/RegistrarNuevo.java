package pe.une.ProductoTest;

import java.util.Scanner;

import pe.une.dao.ProductoDaoImplement;
import pe.une.model.Producto;

public class RegistrarNuevo {
	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		// Crear instancia para los datos.
		ProductoDaoImplement ins = new ProductoDaoImplement();
		System.out.println("Insertar un nuevo producto.");
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
		ins.insertar(pro);
		System.out.println("Nuevo Producto");
		System.out.println(pro.getId_P() + " " + pro.getNombre() + " " 
				+ pro.getPrecio() + " " + pro.getMarca());
	}
}
