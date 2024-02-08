package pe.une.test_Conexion;

import java.sql.Connection;

import pe.une.db.Conexion;

public class Test {

	public static void main(String[] args) {
		// Crear una instancia de la clase conexion
		Conexion cn = new Conexion();// cn es mi instancia de la clase conexion.
		// Realizar la conexion
		Connection cx = cn.conectar();
		// Evaluar si existe coneccion
		if (cx != null) {
			System.out.println("Conectado a Mysql");
			// Cerrar la conexion
			// cn.desconectar();
		} else {
			System.out.println("No hay coneccion con Mysql");
		}

	}

}
