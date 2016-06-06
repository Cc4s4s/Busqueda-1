package examples.8queens;
import framework.AbstractSearchProblem;


import java.util.*;


public class Problema8Queens implements AbstractInformedSearchEngine<EstadoGranja> {
	protected Estado8Queens inicial;
	public int cualMovio;

	public Problema8Queens(){ //Creacion del estado inicial del problema de las 8 reinas
		inicial= new Estado8Queens();
		cualMovio=-1;
	}

	public Problema8Queens(Estado8Queens inicial) {
    	this.inicial = inicial;
    }

    public Estado8Queens initialState() {
        return inicial;
    }
    //Retorna si un estado es inicial o no.
    public boolean esInicial(Estado8Queens s){
		boolean is= true;
		for (int i=0; i < s.queens.length;i++ ) {
			if (s.queens[i]!=0){
				is=false;
			}
		}
		if (is){
			return true;
		}
		else{
			return false;
		}
	}
    //SEGUIR !!!
    public List<Estado8Queens> getSuccessors(Estado8Queens s) {
    	List<Estado8Queens> successors = new LinkedList<Estado8Queens>();
    	if (esInicial(s)){ //Si es el estado inicial (0,0,0,0,0,0,0)
    		Estado8Queens succ= Estado8Queens(0,s.queens[0]+1,s); //(1,0,0,0,0,0,0)
    		successors.add(succ);
    		cualMovio=0;
    	}
    	else{
    		if(cualMovio<1)
    			Estado8Queens succ= Estado8Queens(1,s.queens[1]+1,s); 
    	}	


    	return successors;
    }

    public boolean success(Estado8Queens s){
   		//Pasar los valores del arreglo de donde esta cada reina en cada columna a una matriz
   		//y pegar la funcion de verificacion ya hecha en 8 reynas fuerza bruta. 

    }
    	

}