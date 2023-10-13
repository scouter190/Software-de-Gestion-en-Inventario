package arreglos;
import java.util.ArrayList;

import clases.Items;

public class ArregloItems {
	

	
	private ArrayList<Items> itm;
	
	public ArregloItems(){
		itm= new ArrayList<Items>();
	/*	adicionar(new Items(7643,"Deson 100",20,"Almacen 2"));
		adicionar(new Items(8237,"Taladro atornillador",15,"Almacen 1"));
		adicionar(new Items(7238,"Termómetro de Infrarrojos",10,"Almacen 3"));
		adicionar(new Items(9162,"Inglesa Ajustable",22,"Almacen 2"));*/
		
	}
	
	public int tamanio(){
		return itm.size();
	}
	
	public void adicionar(Items x){
		itm.add(x);
	}
	
	public Items obtener(int i){
		return itm.get(i);
	}
	
	public Items buscar(int idItems){
		for(int i=0;i<tamanio(); i++){
			if(obtener(i).getIdItems()== idItems)
				return obtener(i);
		}
		return null;
	}
	
	
	/*public Items sumaItems(int idItems){
		int cantidadAnterior=0;
		for(int i=0;i<tamanio(); i++){
			if(obtener(i).getIdItems()== idItems)
				cantidadAnterior= obtener(i).getStock();
				
				return obtener(i);
		}
		return null;
	}
	*/
	
	
	
	public Items buscar(String nombre){
		for(int i=0;i<tamanio(); i++){
			if(obtener(i).getNombre().equals(nombre))
				return obtener(i);
		}
		return null;
	}

	
	public void eliminar(Items x){
		itm.remove(x);
	}
	
	public int codigoCorrelativo(){
		if(tamanio()==0){
			return 1002;
		}
		else{
			return obtener(tamanio()-1).getIdItems()+1;
		}
	}
}