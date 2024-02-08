package pe.une.dao;

import java.util.List;

import pe.une.model.Producto;

public interface IProductoDao {
	public List<Producto> buscarTodos();

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public Producto buscarPorCodigo(String Id_P);

	public void darBaja(String Id_P);
}
