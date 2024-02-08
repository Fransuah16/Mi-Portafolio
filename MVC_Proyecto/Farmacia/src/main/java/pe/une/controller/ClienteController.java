package pe.une.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.une.dao.ClienteDaoImplement;
import pe.une.model.Cliente;

@Path("ClienController")
public class ClienteController {
	ClienteDaoImplement dao = new ClienteDaoImplement();

	
	@GET
	@Path("/CliBuscarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientes() {
		List<Cliente> lista = dao.buscarTodos();
		return Response.ok(lista).build();
	}

	
	@GET
	@Path("/Clibuscar/{Dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductosxCodigo(@PathParam("Dni") String Dni) {
		Cliente clie = dao.buscarPorDni(Dni);
		return Response.ok(clie).build();
	}

	
	@POST
	@Path("/Clidarbaja/{Dni}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response darbajaCliente(@PathParam("Dni") String Dni) {
		dao.darBaja(Dni);
		return Response.ok().build();
	}

	
	@PUT
	@Path("/Cliregistrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarCliente(Cliente clie) {
		dao.insertar(clie);
		return Response.ok(clie).build();
	}

	
	@POST
	@Path("/Cliactualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarCliente(Cliente clie) {
		dao.actualizar(clie);
		return Response.ok(clie).build();
	}
}
