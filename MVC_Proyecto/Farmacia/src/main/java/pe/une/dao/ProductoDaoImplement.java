package pe.une.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.une.db.Conexion;
import pe.une.model.Producto;

public class ProductoDaoImplement implements IProductoDao {

	private Connection cx;

	
	public ProductoDaoImplement() {
		cx = Conexion.conectar(); 
	}

	@Override
	public List<Producto> buscarTodos() {
		List<Producto> productos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM producto WHERE Estado=1;";
			Statement st = cx.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Producto pro = new Producto();
				pro.setId_P(rs.getString("Id_P"));
				pro.setNombre(rs.getString("Nombre"));
				pro.setPrecio(rs.getString("Precio"));
				pro.setMarca(rs.getString("Marca"));
				pro.setEstado(rs.getInt("Estado"));
				productos.add(pro);
			}
		} catch (Exception e) {
			System.err.println("Error al consultar datos " + e.getMessage());
		}
		return productos;
	}

	@Override
	public void insertar(Producto producto) {
		try {
			String sql = "INSERT INTO producto(Id_P,Nombre,Precio,Marca,Estado) values(?,?,?,?,1)";

			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, producto.getId_P());
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getPrecio());
			ps.setString(4, producto.getMarca());
			ps.setInt(5, producto.getEstado());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.err.println("Error al ingresar datos " + e.getMessage());
		}

	}

	@Override
	public void actualizar(Producto producto) {
		try {
			String sql = "UPDATE producto SET Nombre=?,Precio=?,Marca=?,Estado=? WHERE Id_P=?";
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getPrecio());
			ps.setString(3, producto.getMarca());
			ps.setInt(4, producto.getEstado());
			ps.setString(5, producto.getId_P());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.err.println("Error al actualizar datos " + e.getMessage());
		}

	}

	@Override
	public Producto buscarPorCodigo(String Id_P) {
		Producto pro1 = new Producto();
		try {
			String sql = "SELECT * FROM producto WHERE Id_P = ?";
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, Id_P);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pro1.setId_P(rs.getString("Id_P"));
				pro1.setNombre(rs.getString("Nombre"));
				pro1.setPrecio(rs.getString("Precio"));
				pro1.setMarca(rs.getString("Marca"));
				pro1.setEstado(rs.getInt("Estado"));
			}
		} catch (Exception e) {
			System.err.println("Error al buscar Producto por codigo " + e.getMessage());
		}
		return pro1;
	}

	@Override
	public void darBaja(String Id_P) {
		try {
			String sql = "UPDATE producto SET Estado=? WHERE Id_P=?";
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, Id_P);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.err.println("Error al dar baja producto " + e.getMessage());
		}

	}

}
