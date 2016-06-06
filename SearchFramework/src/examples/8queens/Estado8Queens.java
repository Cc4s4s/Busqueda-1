//package examples.8queens;


/**
 * Title:        Estado8Queens
 * Description: Implementa la clase State con sus metodos,
 * y como se representa un estado en el problema de las 8 reinas.  
 * Copyright:    Copyright (c) Rondeau, Matias 2016<p>
 * Company:      None<p>
 * @author Rondeau Matias
 * @version 0.1
 */
import framework.State;

public class Estado8Queens implements State{
	private int[] queens; //representa en cada posicion la fila en la que se encuentra una reina con columna fija
	private int n=8; //la cantidad de reinas
	private Estado8Queens parent;//el padre del estado.

	public Estado8Queens (){
		queens = new int[n]; //Inicializacion de todas las reinas en la primera fila
		for (int i=0 ; i < queens.length; i++){
			queens[i]=0;
		}
		parent=null;//estado inicial con padre nulo.
	}
	public Estado8Queens(int col,int newStates,Estado8Queens father){
		//nuevo valor de una reina dada una columna.
		queens[col]=newStates;
		parent=father;
	}
	//Dos estados son iguales si tienen los mismos valores 
	//para cada uno de los elementos del arreglo, es decir
	//si las reinas estan ubicadas de igual manera en cada "tablero".
	public boolean equals(State other){
		Estado8Queens sg = (Estado8Queens) other;
		boolean equalsState=true;
		int i=0;
		while (equalsState || (i < queens.length)  ){
			if (sg.queens[i]!=queens[i])
				equalsState=false;
			i++;
		}
		if(equalsState){
			return true;
		}
		else{
			return false;
		}
	}
	//Retorna el padre del estado.
	public Estado8Queens getParent(){
		return parent;
	} 
	

	//Retorna la tupla de forma string que representa la posicion de cada reina en la fila.
	//Sabiendo que cada reina se mueve sobre una sola columna
	//(0,1,4,3,4,5,6,7)
	//0 esta en fila 0, col 0
	//1 esta en fila 1, col 1
	//4 esta en fila 4, col 2, etc
	public String toString(){
		int i=0;
		String s="(";
		while(i<queens.length){
			s=s+queens[i]+",";
		}
		s=s+")";
		return s;
	}
}