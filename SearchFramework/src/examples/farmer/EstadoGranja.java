package examples.farmer;
import framework.State;
public class EstadoGranja implements State {

    public int granjero; 
    public int zorro; 
    public int gallina; 
    public int maiz; 
    private EstadoGranja parent;

    public EstadoGranja() {
        granjero = 1;
        zorro = 1;
        gallina = 1;
        maiz = 1;
        parent=null;
    }

    public EstadoGranja(int granjero, int zorro, int gallina, int maiz,EstadoGranja father) {
        this.granjero = granjero;
        this.zorro = zorro;
        this.gallina = gallina;
        this.maiz = maiz;
        this.parent=father;
    }

    public static boolean igualSigno(int x, int y) {
        if (x==0 && y==0) return true;
        if (x>0 && y>0) return true;
        if (x<0 && y<0) return true;
        return false;
    }
    //retorna el padre del estado.
    public EstadoGranja getParent(){
        return parent;
    }

    public boolean equals(State other) {
        EstadoGranja sg = (EstadoGranja) other;
        return (igualSigno(granjero,sg.granjero) && igualSigno(zorro,sg.zorro)
                && igualSigno(gallina,sg.gallina) && igualSigno(maiz,sg.maiz));
    }

   public String toString() {
       return ("("+granjero+","+zorro+","+gallina+","+maiz+")");
   }

}
