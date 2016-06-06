package examples.jugs;
import framework.State;

/**
 * Title:        JugsState<p>
 * Description:  class describing the states of the two jugs Problem.
 * It implements interface State. <p>
 * Copyright:    Copyright (c) Nazareno Aguirre 2003,2010<p>
 * Company:      None<p>
 * @author Nazareno Aguirre
 * @version 0.2
 */

public class JugsState implements State {
	
	private int x; // contents of jug A
	private int y; // contents of jug B
	
	
	/** Constructor for JugsState class. It initialises the contents of the 
	 * jugs with the provided parameters.
	 * @param p1 is the integer value used to set the initial contents of the
	 * first jug (A).
	 * @param p2 is the integer value used to set the initial contents of the
	 * second jug (B).
	 * @pre. 0<=p1<=4 and 0<=p2<=3
	 * @post. x is set to p1, and y is set to p2.
	 */
	public JugsState(int p1, int p2)  {
		
		x = p1;
		y = p2;
		
	} 
	
	
	/** Returns the contents of jug A. 
	 * @return an integer representing the contents of jug A.
	 * @pre. true.
	 * @post. An integer representing the contents of jug A is returned.
	 */
	public int getA() {
		return x;
	} 
	
	
	/** Returns the contents of jug B. 
	 * @return an integer representing the contents of jug B.
	 * @pre. true.
	 * @post. An integer representing the contents of jug B is returned.
	 */
	public int getB() {
		return y;
	} 
	
	/** Checks whether a provided JugState is equivalent to the current state.
	 * @param other is the state to be compared with 'this'.
	 * @return true iff 'other' is equivalent to 'this'.
	 * @pre. other is an instance of JugState.
	 * @post. true is returned iff 'other' is equivalent to 'this'.
	 */
	public boolean equals(State other) {
		
		JugsState e = (JugsState) other;
		return((x == e.getA()) &&  (y == e.getB()));
		
	} 
	
	/** 
	 * Returns a representation as a string of the current JugsState. 
	 * @return a string representing the current state.
	 * @pre. true.
	 * @post. A text representation of the current state is returned.
	 */	
	
	public String toString() {
		
		return ("("+x+","+y+")");
		
	} 	
	
} // end of class JugsState
