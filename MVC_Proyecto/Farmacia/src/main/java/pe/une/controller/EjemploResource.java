package pe.une.controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ejemplo")
public class EjemploResource {
	@GET
    public String obtenerEjemplo() {
        return "¡Hola desde JAX-RS!";
    }
}
