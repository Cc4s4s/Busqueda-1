/*Clase MinMaxEngine
 Implementa la clase AdversarySearchEngine
 Y el algoritmo MinMax.
 */
import java.util.*;
import static java.lang.Math.*; //Para usar min y max

public class MinMaxEngine <P extends AdversarySearchProblem<State>, State extends AdversarySearchState> extends AdversarySearchEngine<P,State> {
  
  public MinMaxEngine(){
  	super();
  }

	public MinMaxEngine(P p){
  	super(p);
  }

  public MinMaxEngine(P p,int maxDepth){
  	super(p,maxDepth);
  }
  /*
	---- Algoritmo minMax() ----
	
	Funcion minMax(n) --> Valor
		Si n es hoja 
			retornar valor(n)
		Sino
			x:= MIN_VAL
			y:= MAX_VAL 
			Para cada hijo n_k de n hacer
				Si n es Max
					x:= max(x, minMax(n_k))
				Sino
					y:= min(y, minMax(n_k))
				Fsi
			Fpara
			Si n es Max
				retornar x
			Sino
				retornar y
			Fsi
		Fsi 
	Ffuncion
  */	
	public int minMax(State s){
		if(problem.end(s)){
			return problem.value(s);
		}
		else{
			int x= Integer.MIN_VALUE;
			int y= Integer.MAX_VALUE;
			//obtener los sucesores
			List<State> successor = problem.getSuccessors(s);
			while (!successor.isEmpty()){
				if (s.isMax())
					x= max(x,minMax(successor.get(0)));
				else 	
					y= min (y, minMax(successor.get(0)));		
				successor.remove(0);
			}
			if (s.isMax())
				return x;
			
			return y;
		}		
	}

    /*
	Inicia la búsqueda con el fin de calcular un valor para un estado.
	El cálculo se lleva a cabo mediante la exploración del árbol de juego 
	correspondiente al problema, teniendo en cuenta el estado como la raíz, 
	y con la máxima maxDepth() profundidad.
	*/
	public int computeValue(State state){
		return minMax(state);
	}	

	/*
	Inicia la búsqueda con el fin de calcular un sucesor más prometedor para un estado. 
	El cálculo se lleva a cabo mediante la exploración del árbol de juego correspondiente 
	al problema, teniendo en cuenta el estado como la raíz, 
	y con la máxima maxDepth profundidad.
	*/

	//GUARDAR EL ESTADO CON SU VALOR (VALOR,ESTADO). GUARDAR TODOS EN UNA LISTA.
	//LUEGO SACAR EL MEJOR(RECORRIENDO LA LISTA)
	public State computeSuccessor(State state){
		State s=null;
		return s;
	}

	public void report(){

	}

}