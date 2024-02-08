package pe.une.ClienteTest;

import java.util.Scanner;

import pe.une.dao.ClienteDaoImplement;
import pe.une.model.Cliente;

public class CliActualizar {

	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		ClienteDaoImplement dao = new ClienteDaoImplement();
		System.out.println("Actualizar CLeinte");
		System.out.println("Ingrese DNI");
		String dni = Leer.nextLine();
		System.out.println("Ingrese Nombre:");
		String nombre = Leer.nextLine();
		System.out.println("Ingrese Apellidos:");
		String apellidos = Leer.nextLine();
		System.out.println("Ingrese Estado");
		int estado = Leer.nextInt();
		System.out.println("Ingrese Id de Venta");
		String venta = Leer.next();
		Cliente clien= new Cliente(dni,nombre,apellidos,estado,venta);
		dao.actualizar(clien);
		System.out.println("Cliente Actualizado");
	}

}
