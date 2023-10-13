package clases;

public class Items {
	private int idItems;
	private String nombre;
	private int stock;
	private String ubicacion;
	public Items(int idItems, String nombre, int stock, String ubicacion) {
		super();
		this.idItems = idItems;
		this.nombre = nombre;
		
		this.stock = stock;
		this.ubicacion = ubicacion;
	}
	public int getIdItems() {
		return idItems;
	}
	public void setIdItems(int idItems) {
		this.idItems = idItems;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getUbicación() {
		return ubicacion;
	}
	public void setUbicación(String ubicación) {
		this.ubicacion = ubicación;
	}
	
	
	
	
	
}
