package pe.une.model;

public class Cliente{
	private String Dni;
	private String Nombre;
	private String Apellido;
	private int Estado;
	private String Id_Venta;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String dni, String nombre, String apellido, int estado, String id_Venta) {
		super();
		this.Dni = dni;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Estado = estado;
		this.Id_Venta = id_Venta;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public String getId_Venta() {
		return Id_Venta;
	}

	public void setId_Venta(String id_Venta) {
		Id_Venta = id_Venta;
	}
	
	
	
	
	
}
