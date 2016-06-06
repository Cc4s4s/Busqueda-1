package framework;

public class Pair <A,B>{
    private A x;
    private B y;

    /* Pair(): Constructor of the class */	
    public Pair() {
	x = null;
	y = null;
    }

    /* Pair(Object, Object): Constructor of the class */	
    public Pair(A v1, B v2) {
	x = v1;
	y = v2;
    }

    /* ChangeFst: Updates the value of var. x */	
    public void changeFst(A v1) {
	x = v1;
    }

    /* ChangeSnd: Updates the value of var. y */		
    public void changeSnd(B v2) {
	y = v2;
    }

    /* fst: Returns the value of var. x */	
    public A fst() {
	return x;
    }

    /* snd: Returns the value of var. y */		
    public B snd() {
	return y;
    }

} // end of class Pair
