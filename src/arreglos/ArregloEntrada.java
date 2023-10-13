package arreglos;

import java.util.ArrayList;

import clases.Entrada;

public class ArregloEntrada {
	private ArrayList<Entrada> entrada;
		
	public ArregloEntrada() {
		entrada= new ArrayList<Entrada>();
			
	}
	public void adicionar(Entrada x){
		entrada.add(x);
	}
	
	public int tamanio(){
		return entrada.size();
	}
	
	public Entrada obtener(int i){
		return entrada.get(i);
	}

	public Entrada buscar(int codigo){
		for(int i=0; i<tamanio(); i++){
			if(obtener(i).getCodigoEntrada()== codigo){
				return obtener(i);
			}
		}
		return null;
	}
	
	public int codigoCorrelativo(){
		if(tamanio()==0){
			return 9001;
		}
		else{
			return obtener(tamanio()-1).getCodigoEntrada()+1;
		}
	}
	
	
}
