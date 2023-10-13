package arreglos;
import java.util.ArrayList;

import clases.Categoria;
import clases.Proveedor;

public class ArregloCategoria {
	private ArrayList<Categoria> cate;
	
	public ArregloCategoria(){
		cate= new ArrayList<Categoria>();
		adicionar(new Categoria(1001, "Herramienta"));
	}
	
	public void adicionar(Categoria x){
		cate.add(x);
	}
	
	public int tamanio(){
		return cate.size();
	}
	
	public Categoria obtener(int i){
		return cate.get(i);
	}

	public void eliminarTodo(){
		cate.clear();
	}
	public void eliminarFinal(){
		cate.remove(tamanio()-1);
	}
	public void eliminar(Categoria x){
		cate.remove(x);
	}
	
	public int codigoCorrelativo(){
		if(tamanio()==0){
			return 1002;
		}
		else{
			return obtener(tamanio()-1).getIdCategoria()+1;
		}
	}
	
	public Categoria buscar(int codigo){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getIdCategoria()== codigo){
				return obtener(i);
			}
		}
		return null;
	}
	
	public Categoria buscar(String nombre){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getNombreCategoria()== nombre){
				return obtener(i);
			}
		}
		return null;
	}
	

}

