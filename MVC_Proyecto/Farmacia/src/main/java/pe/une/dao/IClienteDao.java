package pe.une.dao;

import java.util.List;

import pe.une.model.Cliente;

public interface IClienteDao {
	public List<Cliente> buscarTodos();

	public void insertar(Cliente cliente);

	public void actualizar(Cliente cliente);

	public Cliente buscarPorDni(String Dni);

	public void darBaja(String Dni);

}
