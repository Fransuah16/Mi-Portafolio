package pe.une.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.une.db.Conexion;
import pe.une.model.Cliente;

public class ClienteDaoImplement implements IClienteDao {

	private Connection cx;

	// constructor
	public ClienteDaoImplement() {
		cx = Conexion.conectar();
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			String sql = "SELECT * FROM cliente WHERE Estado=1;";
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(sql);
		
			while (rs.next()) { //while
				Cliente clien = new Cliente();
				clien.setDni(rs.getString("Dni"));
				clien.setNombre(rs.getString("Nombre"));
				clien.setApellido(rs.getString("Apellido"));
				clien.setEstado(rs.getInt("Estado"));
				clien.setId_Venta(rs.getString("Id_Venta"));
				clientes.add(clien);
			}
		} catch (Exception e) {
			System.err.println("Error al consultar datos " + e.getMessage());
		}
		return clientes;
	}

	@Override
	public void insertar(Cliente cliente) {
		try {
			String sql = "INSERT INTO cliente(Dni,Nombre,Apellido,Estado,Id_Venta) values(?,?,?,?,?)";

			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellido());
			ps.setInt(4, cliente.getEstado());
			ps.setString(5, cliente.getId_Venta());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			System.err.println("Error al ingresar datos " + e.getMessage());
		}
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		try {
			String sql = "UPDATE cliente SET Nombre=?,Apellido=?,Estado=?,Id_Venta=? WHERE Dni=?";
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setInt(3, cliente.getEstado());
			ps.setString(4, cliente.getId_Venta());
			ps.setString(5, cliente.getDni());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.err.println("Error al actualizar datos " + e.getMessage());
		}
		
	}

	@Override
	public Cliente buscarPorDni(String Dni) {
		Cliente clien1 = new Cliente();
		try {
			String sql = "SELECT * FROM cliente WHERE Dni = ?";
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, Dni);// 
			ResultSet rs = ps.executeQuery();// e
			while (rs.next()) {
				clien1.setDni(rs.getString("Dni"));
				clien1.setNombre(rs.getString("Nombre"));
				clien1.setApellido(rs.getString("Apellido"));
				clien1.setEstado(rs.getInt("Estado"));
				clien1.setId_Venta(rs.getString("Id_Venta"));
			}

		} catch (Exception e) {
			System.err.println("Error al buscar por codigo " + e.getMessage());
		}
		return clien1;
	}

	@Override
	public void darBaja(String Dni) {
		try {
			String sql = "UPDATE cliente SET Estado=? WHERE dni=?";
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, Dni);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.err.println("Error al ocultar " + e.getMessage());
		}
		
	}
	
	

	

}
