package framework;

import java.util.*; // necessary due to the use of lists.

public class BreadthFirstEngine<S extends State> extends AbstractSearchEngine<S> {
	
    private List<S> visited; // used to store the visited states
    private List<S> path; // used to store the path to the success.
   	private S success; //store succes state.
	/** 
	 * Constructor for class BreadthFirstEngine.  
	 * @pre. true.
	 * @post. Lists visited and path are initialised as empty.
	 */	
    public BreadthFirstEngine() {
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
    public BreadthFirstEngine(AbstractSearchProblem<S> p) {		
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
	
	public boolean performSearch() {
        // we get the initial state
        S initialState = problem.initialState();
		// now we call a recursive method implementing depth-first
		boolean resultSearch = bfs(initialState);
		return resultSearch;
		
    } // end of method performSearch


    /** 
	 * Method that performs the search implementing a Breadth-first visit 
	 * @return true iff a successful state is found.
	 * @pre. problem!=null.
	 * @post. the search is performed, the visited are stored in
	 * list visited, the path in list path, and true is returned iff a       
     * successfull state is found.	 
	 */
	 public boolean bfs(S s){
    	if (s==null){
    		throw new IllegalArgumentException("bfs: Problem-parameter is null");
    	}else{ 	
		   	Queue<S> queue = new LinkedList<S>();
    		queue.add(s);
    		boolean exito = false;
    		S current = queue.peek(); //solo para inicializar luego se pisa el valor.
    		while (!exito && !queue.isEmpty() ) {
    			current = queue.poll();
    			exito= problem.success(current);
  				queue.addAll(problem.getSuccessors(current));
  				
   			}
   			success=current; //seteo la variable global con success (exito)
    		return exito;
  		}
  	}

	/** 
	 * Returns the path to a previously calculated successful state for problem.
	 * @return the list of nodes corresponding to the path from the root to
	 * the successful node.
	 * @pre. performSearch() has been executed and finished successfully.
	 * @post. the path to the found success node is returned.  
	 */	
    public List<S> getPath() {
        //success ,backup del "exito" guardado en clase.
		S succElem= success;
		List<S> aux = new LinkedList<S>();
		aux.add((S) succElem); 
        while (succElem.getParent()!= null){
      		aux.add( (S) succElem.getParent() );
       		succElem= (S) succElem.getParent();	
        }
        int i = aux.size()-1;
        while (i>=0){
        	path.add((S) aux.get(i));
        	aux.remove(i);
        	i--;
        }
        
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