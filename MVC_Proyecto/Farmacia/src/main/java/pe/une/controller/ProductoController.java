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

import pe.une.dao.ProductoDaoImplement;
import pe.une.model.Producto;

@Path("ProController")
public class ProductoController {
	ProductoDaoImplement dao = new ProductoDaoImplement();

	
	@GET
	@Path("/ProBuscarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductos() {
		List<Producto> lista = dao.buscarTodos();
		return Response.ok(lista).build();
	}

	
	@GET
	@Path("/Probuscar/{Id_P}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductosxCodigo(@PathParam("Id_P") String Id_P) {
		Producto prod = dao.buscarPorCodigo(Id_P);
		return Response.ok(prod).build();
	}

	
	@POST
	@Path("/Prodarbaja/{Id_P}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response darbajaProducto(@PathParam("Id_P") String Id_P) {
		dao.darBaja(Id_P);
		return Response.ok().build();
	}

	
	@PUT
	@Path("/Proregistrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarProducto(Producto prod) {
		dao.insertar(prod);
		return Response.ok(prod).build();
	}

	
	@POST
	@Path("/Proactualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarProducto(Producto prod) {
		dao.actualizar(prod);
		return Response.ok(prod).build();
	}
}
