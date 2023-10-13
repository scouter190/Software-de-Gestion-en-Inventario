package arreglos;
import java.util.ArrayList;

import clases.Categoria;
import clases.UnidadMedida;


public class ArregloUnidadMedida {
	private ArrayList<UnidadMedida> uni;
	
	public ArregloUnidadMedida(){
		uni= new ArrayList<UnidadMedida>();
		adicionar(new UnidadMedida(2001, "Unidad"));
	}
	
	public void adicionar(UnidadMedida x){
		uni.add(x);
	}
	
	public int tamanio(){
		return uni.size();
	}
	
	public UnidadMedida obtener(int i){
		return uni.get(i);
	}

	public void eliminarTodo(){
		uni.clear();
	}
	public void eliminarFinal(){
		uni.remove(tamanio()-1);
	}
	public void eliminar(UnidadMedida x){
		uni.remove(x);
	}
	
	public int codigoCorrelativo(){
		if(tamanio()==0){
			return 2002;
		}
		else{
			return obtener(tamanio()-1).getIdUnidadMedida()+1;
		}
	}
	
	public UnidadMedida buscar(int codigo){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getIdUnidadMedida()== codigo){
				return obtener(i);
			}
		}
		return null;
	}
	public UnidadMedida buscar(String nombre){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getNombreMedida()== nombre){
				return obtener(i);
			}
		}
		return null;
	}
	

}

