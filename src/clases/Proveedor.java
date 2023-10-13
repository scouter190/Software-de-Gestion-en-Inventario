package clases;

public class Proveedor {
	private int id;
	private String ruc;
	private String razonSocial;

	
	public Proveedor(int id,String ruc, String razonSocial) {
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.id = id;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
	


}
