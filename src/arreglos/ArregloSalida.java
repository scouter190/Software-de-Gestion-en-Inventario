package arreglos;

import java.util.ArrayList;

import clases.Personal;
import clases.Salida;;

public class ArregloSalida {

	private ArrayList<Salida> salida;
	
	public ArregloSalida() {
		salida= new ArrayList<Salida>();
			
	}
	public void adicionar(Salida x){
		salida.add(x);
	}
	
	public int tamanio(){
		return salida.size();
	}
	
	public Salida obtener(int i){
		return salida.get(i);
	}

	public Salida buscar(int codigo){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getCodigoSalida()== codigo){
				return obtener(i);
			}
		}
		return null;
	}
	
	public int codigoCorrelativo(){
		if(tamanio()==0){
			return 2020;
		}
		else{
			return obtener(tamanio()-1).getCodigoSalida()+20;
		}
	}
	public void eliminar(Salida x){
		salida.remove(x);
	}
}