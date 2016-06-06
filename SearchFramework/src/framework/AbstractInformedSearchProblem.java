package framework;
/**
 * Title:        AbstractInformedSearchProblem<p>
 * Description:  Interface which defines the basic elements necessary for 
 * characterising a problem as a informed search. Instances of these problems should 
 * implement this interface, to be able to use the informed search strategies.<p>         
 * Copyright:    Copyright (c) Gaston Scilingo 2011<p>
 * Company:      Dpto. de Computacion, FCEFQyN, UNRC<p>
 * @author Gaston Scilingo
 * @version 0.1
 **/

import java.util.Comparator;

public interface AbstractInformedSearchProblem<S extends State> extends AbstractSearchProblem<S> {
	
	/**
	 * This method compute a value of a state.
	 * @param s state to be valued.
	 * @return value of state.
	 */
	abstract public int getValue(S s);
	
	
	/**
	 * this method provide a states comparator for used in informed search algorithm
	 * @return Comparator object
	 */
	abstract public Comparator<S> getComparator();

	
}
