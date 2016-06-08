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
		if(problem.end(s)){//Si es una hoja
			return problem.value(s);//retorno su valor
		}
		else{
			int x= Integer.MIN_VALUE;//Minimo valor Entero representable
			int y= Integer.MAX_VALUE;//Maximo valor Entero representable
			//obtener los sucesores
			List<State> successor = problem.getSuccessors(s);
			//mientras tenga sucesores
			while (!successor.isEmpty()){
				if (s.isMax()) //Si s es un estado Maximo
					x= max(x,minMax(successor.get(0)));
				else  //Si s es un estado Minimo	
					y= min (y, minMax(successor.get(0)));		
				successor.remove(0); //elimino elemento para avanzar.
			}
			if (s.isMax()) //Si s es maximo retornar el valor int x.
				return x;
			
			return y; //Sino retornar el valor int y minimo.
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
	//LUEGO SACAR EL MEJOR(RECORRIENDO LA LISTA) Y RETORNAR ESE ESTADO.
	public State computeSuccessor(State state){
		List<State> successors = problem.getSuccessors(state); //sucesores de state
		List<Pair<Integer,State>> succValue = new LinkedList<Pair<Integer,State>>(); 
		Pair<Integer,State> current= new Pair<Integer,State>();// (Int,State)
		int i=0;
		while (!successors.isEmpty()){
			State st= successors.get(0); //obtengo state succesor
			i=computeValue(st); //computo MinMax para ese estado
			current.setTwo(Integer.valueOf(i),st); //seteo el par con valores
			succValue.add(current);//agrego a la lista de pares
			successors.remove(0);//elimino el succesor para avanzar
		}
		//Guardar el indice donde se encuentra Max 
		int max=0;
		i=0;
		while (i < succValue.size()){
			if ( (succValue.get(max)).getFst() < (succValue.get(i)).getFst() ){
				max=i;
			}
			i++;
		}
		return (succValue.get(max)).getSnd(); //Retorno el estado mas prometedor.
	}

	public void report(){

	}

}