package pe.une.ClienteTest;

import java.util.Scanner;

import pe.une.dao.ClienteDaoImplement;
import pe.une.model.Cliente;

public class ClieInsertar {

	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		ClienteDaoImplement ins = new ClienteDaoImplement();
		System.out.println("Insertar Nuevo CLeinte");
		System.out.println("Ingrese DNI");
		String dni = Leer.nextLine();
		System.out.println("Ingrese Nombre:");
		String nombre = Leer.nextLine();
		System.out.println("Ingrese Apellidos:");
		String apellidos = Leer.nextLine();
		System.out.println("Ingrese Id de Venta");
		String venta = Leer.next();
		Cliente clien1 = new Cliente(dni,nombre,apellidos,1,venta);
		ins.insertar(clien1);
	}

}
