package framework;
/**
 * Title:		AbstractInformedSearchEngine<p>
 * Description:	abstract class which defines the basic elements that are required for a
 * 				search engine. Different informed search strategies should extend this class.
 * Copyright:    Copyright (c) Gaston Scilingo 2011<p>
 * Company:      Dpto. de Computacion, FCEFQyN, UNRC<p>
 * @author Gaston Scilingo
 * @version 0.1
 */

import java.util.List;


public abstract class AbstractInformedSearchEngine<P extends AbstractInformedSearchProblem<State>> extends	AbstractSearchEngine {
	
    protected P problem;

	/** 
	 * Constructor for abstract class AbstractInformedSearchEngine 
	 * @pre. true.
	 * @post. This constructor does nothing (skip).
	 */
	public AbstractInformedSearchEngine() {}
	
	/** 
	 * Constructor for abstract class AbstractInformedSearchEngine.
	 * @param p is the abstract informed search problem associated with the engine
	 * being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem.
	 */
    public AbstractInformedSearchEngine(P p) {
        problem = p;
    }

	@Override
	abstract public boolean performSearch();
	
	@Override
	abstract public List<State> getPath();


	@Override
	abstract public void report();
	
	/** 
	 * Sets the problem associated with the search engine.
	 * @param p is the search problem to be used for search (to set 'problem' to).
	 * @pre. p!=null.
	 * @post. 'problem' is set to p.
	 */	
	public void setProblem(P p) {
        problem = p;
    }
	
}
