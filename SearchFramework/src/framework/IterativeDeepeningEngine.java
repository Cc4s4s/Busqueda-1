package framework;

import java.util.*; // necessary due to the use of lists.

public class IterativeDeepeningEngine<S extends State> extends AbstractSearchEngine<S> {
	
    private List<S> visited; // used to store the visited states
    private List<S> path; // used to store the path to the success.
	/** 
	 * Constructor for class BreadthFirstEngine.  
	 * @pre. true.
	 * @post. Lists visited and path are initialised as empty.
	 */	
    public IterativeDeepeningEngine() {
		super();
		visited = new LinkedList<S>();
		path = new LinkedList<S>();
	}

    /** 
	 * Constructor for class BreadthFirstEngine.
	 * @param p is the search problem associated with the engine
	 * being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem. Lists visited and
	 * path are initialised as empty.
	 */	
    public IterativeDeepeningEngine(AbstractSearchProblem<S> p) {		
		super(p);
		visited = new LinkedList<S>();
		path = new LinkedList<S>();
    }

    /** 
	 * Starts the search for successful states for problem, following a 
	 * breadth-first strategy.
	 * @return true iff a successful state is found.
	 * @pre. problem!=null.
	 * @post. the search is performed, the visited are stored in
	 * list visited, the path in list path, and true is returned iff a       
     * successfull state is found.	 
	 */
	//ITERATIVE DEEPENING
	public boolean performSearch() {
        
		// first, we initialise the data structures for the search
		visited = new LinkedList<S>();
		// we get the initial state
        S initialState = problem.initialState();
		// now we call a recursive method implementing depth-first
		int k=0;
		boolean resultSearch=false;
		while (!resultSearch && k<8){ //PUESTO EL K PARA QUE TERMINE, SOLO PARA PRUEBA. 
			int i=0;
			resultSearch = iterativeDeep(initialState,k,i);
			k++;
		}
		return resultSearch;
		
    } // end of method performSearch


    private boolean iterativeDeep(S s,int k,int i) {
		if (!visited.contains(s)) {
			visited.add(0, s); // we add s to the list of visited   
            if (problem.success(s)) {
				
				path.add(0,s); // we add the success state to the path
				return true;
				
				
			} // end then branch
			else {
				List<S> succ_s = problem.getSuccessors(s);
				boolean found = false;
				while ( (!succ_s.isEmpty()) && (!found) && (i <= k) )  {
					
					S child = succ_s.get(0);
					succ_s.remove(0);
					i++;
					found = iterativeDeep(child,k,i);
					
				} // end while
				if (found) {
					// s leads to a success, so we add it to the path
					path.add(0, s);
				}
				return found;
				
			} // end else branch
        }
		else {
			return false;
		}

    } // end of recursiveDepthFirst

	/** 
	 * Returns the path to a previously calculated successful state for problem.
	 * @return the list of nodes corresponding to the path from the root to
	 * the successful node.
	 * @pre. performSearch() has been executed and finished successfully.
	 * @post. the path to the found success node is returned.  
	 */	
    public List<S> getPath() {
    	return path;
    } // end of getPath()
    
	
	/** 
	 * Reports information regarding a previously executed search.   
	 * @pre. performSearch() has been executed and finished.
	 * @post. A report regarding the search is printed to standard output.
	 * This report consists of the length of the path obtained, and the number
	 * of visited states.
	 */    
	public void report() {
        System.out.println("Length of path to state when search finished: "+path.size());
		System.out.println("Number of visited when search finished: "+visited.size());
		
    } // end of report()
	



}	