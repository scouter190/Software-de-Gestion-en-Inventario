package arreglos;

import java.util.ArrayList;

import clases.Categoria;
import clases.Personal;


public class ArregloPersonal {
	
	private ArrayList<Personal>per;
	
	public ArregloPersonal(){
		
		per = new ArrayList<Personal>();
		
		adicionar(new Personal(1010,"Julian","Álvarez",904903876));
		adicionar(new Personal(1020,"Isabel","Fernandez",904903876));

		
	}
	
	public int tamanio(){
		return per.size();
	}
	
	public void adicionar(Personal x){
		per.add(x);
	}
	
	public Personal obtener(int i){
		return per.get(i);
	}
	
	public Personal buscar(int codigo){
		for(int i=0;i<tamanio(); i++){
			if(obtener(i).getCodigo()== codigo)
				return obtener(i);
		}
		return null;
	}
	public Personal buscar(String nombre){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getNombre()== nombre){
				return obtener(i);
			}
		}
		return null;
	}
	
	public int codigoCorrelativo(){
		if(tamanio()==0){
			return 1010;
		}
		else{
			return obtener(tamanio()-1).getCodigo()+10;
		}
	}
	public void eliminar(Personal x){
		per.remove(x);
	}
}