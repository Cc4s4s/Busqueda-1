package framework;

/**
 * Title:        AbstractSearchProblem<p>
 * Description:  IInterface which defines the basic elements necessary for 
 * characterising a problem as a search. Instances of these problems should 
 * implement this interface, to be able to use the search strategies. <p>         
 * Copyright:    Copyright (c) Nazareno Aguirre 2003,2010<p>
 * Company:      Dpto. de Computacion, FCEFQyN, UNRC<p>
 * @author Nazareno Aguirre & Gaston
 * @version 0.4
 */

//import framework.State;
import java.util.*; // necessary due to the use of lists.
public interface AbstractSearchProblem<S extends State> {

	/** 
	 * Returns the initial state corresponding to the problem. Concrete
	 * implementations of AbstractSearchProblem must implement this routine,
	 * to indicate the starting point for the search.
	 * @return the initial state for the problem
	 * @pre. true.
	 * @post. the initial state for the problem is returned.  
	 */
    abstract public S initialState();
    

	/** 
	 * Returns the list of successor states for a given state, in the context of
	 * the current problem. Concrete implementations of AbstractSearchProblem 
	 * must implement this routine, to indicate the 'advance' rules for the 
	 * search.
	 * @param s is the state for which its successors are being computed.
	 * @return the list of successor states of s.
	 * @pre. s!=null.
	 * @post. the list of successor states of s is returned.  
	 */
    abstract public List<S> getSuccessors(S s);
    
    
	/** 
	 * Indicates whether a given state is a successful state, in the context of
	 * the current problem. Concrete implementations of AbstractSearchProblem 
	 * must implement this routine, to indicate when the search has been  
	 * successful.
	 * @param s is the state being checked to be successful.
	 * @return true iff s is a successful state.
	 * @pre. s!=null.
	 * @post. true is returned iff s is a successful state.  
	 */
    abstract public boolean success(S s);
 
   
} 
