package pe.une.ClienteTest;

import java.util.Scanner;

import pe.une.dao.ClienteDaoImplement;

public class CliedarBaja {
	public static void main(String[] args) {
		Scanner Leer = new Scanner(System.in);
		ClienteDaoImplement dao = new ClienteDaoImplement();
		System.out.println("Ingrese DNI");
		String dni = Leer.next();
		dao.darBaja(dni);
		System.out.println("Proceso Terminado");
	}
}
