package arreglos;

import java.util.ArrayList;

import clases.Proveedor;

public class ArregloProveedores {
	
	private ArrayList<Proveedor> prov;

	public ArregloProveedores() {
		prov = new ArrayList<Proveedor>();
		
		adicionar(new Proveedor(001,"98736273801","Rothenberger"));
		adicionar(new Proveedor(002,"83647836471","Seggopi"));
		adicionar(new Proveedor(003,"83917283916","Alve"));
		adicionar(new Proveedor(004,"82649371192","Hardmetals Tools"));
		
	}
	
	public int tamanio(){
		return prov.size();
	}
	
	public void adicionar(Proveedor x){
		prov.add(x);
	}
	
	public Proveedor obtener(int i){
		return prov.get(i);
	}
	
	public Proveedor buscar(int id){
		for(int i=0;i<tamanio(); i++){
			if(obtener(i).getId()==id)
				return obtener(i);
		}
		return null;
	}
	public Proveedor buscar(String nombre){
		for(int i=0;i<tamanio(); i++){
			if(obtener(i).getRazonSocial().equals(nombre))
				return obtener(i);
		}
		return null;
	}
	
	public void eliminar(Proveedor x){

		prov.remove(x);
	}
	
	public int codigoCorrelativo(){
		if(tamanio() == 0)
			return 001;
		else 
			return obtener(tamanio() -1).getId() +1;
	}
	
	

}
