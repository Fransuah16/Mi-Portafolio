package pe.une.model;

public class Producto {
	private String Id_P;
	private String Nombre;
	private String Precio;
	private String Marca;
	private int Estado;
	
	//Constructores
	public Producto() {
		
	}

	public Producto(String id_P, String nombre, String precio, String marca, int estado) {
		super();
		this.Id_P = id_P;
		this.Nombre = nombre;
		this.Precio = precio;
		this.Marca = marca;
		this.Estado = estado;
	}

	public String getId_P() {
		return Id_P;
	}

	public void setId_P(String id_P) {
		Id_P = id_P;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPrecio() {
		return Precio;
	}

	public void setPrecio(String precio) {
		Precio = precio;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

}

