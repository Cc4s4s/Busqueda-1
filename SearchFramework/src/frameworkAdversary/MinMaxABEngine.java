/*Clase MinMaxABEngine
 Implementa la clase AdversarySearchEngine
 Y el algoritmo MinMax con poda Alfa-Beta.
 */
import java.util.*;
import static java.lang.Math.*; //Para usar min y max

public class MinMaxABEngine <P extends AdversarySearchProblem<State>, State extends AdversarySearchState> extends AdversarySearchEngine<P,State> {
  
  public MinMaxABEngine(){
  	super();
  }

	public MinMaxABEngine(P p){
  	super(p);
  }

  public MinMaxABEngine(P p,int maxDepth){
  	super(p,maxDepth);
  }
  /*
	---- Algoritmo minMaxAB() ----
	
	Funcion minMaxAB(n, alfa, beta) --> Valor
		Si n es hoja o esta a nivel maximo
			retornar valor(n)
		Sino
			Para cada hijo n_k de n y mientras alfa<beta hacer
				Si n es Max
					alfa:= max(alfa, minMaxAB(n_k, alfa, beta))
				Sino
					beta:= min(beta, minMaxAB(n_k, alfa, beta))
				Fsi
			Fpara
			Si n es Max
				retornar alfa
			Sino
				retornar beta
			Fsi

		Fsi 
	Ffuncion
  */	
	public int minMaxAB(State s,int alfa, int beta,int depth){
		if(problem.end(s)|| depth==0){ //depth==0 ??? (Profundidad 0)
			return problem.value(s);
		}
		else{
			//obtener los sucesores
			List<State> successor = problem.getSuccessors(s);
			//mientras haya sucesores y se respete la cota
			while (!successor.isEmpty() && alfa<beta){
				if (s.isMax()) //s es un estado Maximo 
					alfa= max(alfa, minMaxAB(successor.get(0), alfa, beta, depth-1));
				else 	//s es un estado Minimo
					beta= min (beta, minMaxAB(successor.get(0), alfa, beta, depth-1));		
				successor.remove(0);//avanzar
			}
			if (s.isMax())
				return alfa;
			
			return beta;
		}		
	}

    /*
	Inicia la búsqueda con el fin de calcular un valor para un estado.
	El cálculo se lleva a cabo mediante la exploración del árbol de juego 
	correspondiente al problema, teniendo en cuenta el estado como la raíz, 
	y con la máxima maxDepth() profundidad.
	*/
	public int computeValue(State state){
		return 0;
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
				max=i; //intercambio si encontro otro max.
			}
			i++;
		}
		return (succValue.get(max)).getSnd(); //Retorno el estado mas prometedor.
	}

	public void report(){

	}

}