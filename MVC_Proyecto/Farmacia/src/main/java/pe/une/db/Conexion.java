package pe.une.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	protected static Connection cx;

	public static Connection conectar() {

		if (cx != null) {
			return cx;
		}
		try {// para realizar la conexion con la BD, si es que cx es null.
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/dbfarmacia?serverTimezone=UTC";
			String user = "root";
			String pass = "abcd1234";
			Class.forName(driver);
			cx = DriverManager.getConnection(url, user, pass);
		} catch (Exception ex) {
			System.out.println("Error al conectar BD: " + ex.getMessage());
		}
		return cx;
	}

	// Metodo que permite desconectar de la DB
	public static void desconectar() {
		if (cx == null) {
			return;
		}
		try {
			cx.close();
		} catch (Exception ex) {
			System.out.println("Error al Desconectar BD " + ex.getMessage());
		}
	}
}
