package examples.farmer;


import java.util.*;

import framework.DepthFirstEngine;
import framework.BreadthFirstEngine;
import framework.IterativeDeepeningEngine;
public class appGranja {

	public static void main(String[] args) {


		ProblemaGranja p = new ProblemaGranja();
		
		DepthFirstEngine<EstadoGranja> engine1 = new DepthFirstEngine<EstadoGranja>(p);
		BreadthFirstEngine<EstadoGranja> engine2 = new BreadthFirstEngine<EstadoGranja>(p);
		IterativeDeepeningEngine<EstadoGranja> engine3 = new IterativeDeepeningEngine<EstadoGranja>(p);
		//VALOR DE DEPTH
		//boolean success = engine1.performSearch();
		//VALOR DEL BREADTH
		boolean success2= engine2.performSearch();
		//Iterative Deepening Engine result.
		boolean success3= engine3.performSearch();
		//PARA DEPTH FIRST SEARCH.
		/*System.out.println();	    	    
		System.out.println("*** Result using depth-first search ***");
		System.out.println("Solution found? " + success);
		if (success) {
			System.out.print("Path to goal: ");
			List<EstadoGranja> path = engine1.getPath();
			for (int i=0; i<path.size(); i++) {
				EstadoGranja current = path.get(i);
				System.out.print(current.toString());
			}
			System.out.println();
		}
		engine1.report();
		*/		
		//PARA BREADTH FIRST SEARCH
		System.out.println();
		System.out.println("*** Result using Breadth - First Search ****");
		System.out.println();
		System.out.println("Solution found? " + success2);
		if (success2){
			System.out.println("Path de recorrido : ");
			List<EstadoGranja> path = engine2.getPath();
			for (int i=0; i<path.size(); i++) {
				EstadoGranja current = path.get(i);
				System.out.println(current.toString());
			}
			System.out.println();
		}
		engine2.report();
	
		//Para iterative Deepening
		System.out.println();
		System.out.println("*** Result using IterativeDeepening Search ****");
		System.out.println();
		System.out.println("Solution found? " + success3);
		if (success3){
			System.out.println("Path de recorrido : ");
			List<EstadoGranja> path = engine3.getPath();
			for (int i=0; i<path.size(); i++) {
				EstadoGranja current = path.get(i);
				System.out.println(current.toString());
			}
			System.out.println();
		}
		engine3.report();



	} // end of main

} // end of appGranja
