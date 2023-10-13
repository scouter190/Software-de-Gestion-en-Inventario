package clases;

public class UnidadMedida {
	private int idUnidadMedida;
	private String nombreMedida;
	public UnidadMedida(int idUnidadMedida, String nombreMedida) {
		super();
		this.idUnidadMedida = idUnidadMedida;
		this.nombreMedida = nombreMedida;
	}
	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}
	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}
	public String getNombreMedida() {
		return nombreMedida;
	}
	public void setNombreMedida(String nombreMedida) {
		this.nombreMedida = nombreMedida;
	}
	
	
	
}
