package examples.farmer;
import framework.AbstractSearchProblem;


import java.util.*;


public class ProblemaGranja implements AbstractInformedSearchEngine<EstadoGranja> {

        protected EstadoGranja inicial;

        public ProblemaGranja() {
            inicial = new EstadoGranja();
        }

        public ProblemaGranja(EstadoGranja inicial) {
            this.inicial = inicial;
        }

        public EstadoGranja initialState() {
            return inicial;
        }

        //agrego como parametro del constructor "s" que va a ser el padre del estado proximo o sucesores que se estan construyendo.
        public List<EstadoGranja> getSuccessors(EstadoGranja s) {
            List<EstadoGranja> successors = new LinkedList<EstadoGranja>();
            if (s.granjero==0 || s.zorro==0 || s.gallina==0 || s.maiz==0) return (successors);
            EstadoGranja soloGranjero = new EstadoGranja(s.granjero*-1,s.zorro,s.gallina,s.maiz,s);
            if (!EstadoGranja.igualSigno(soloGranjero.granjero,soloGranjero.gallina) && EstadoGranja.igualSigno(soloGranjero.gallina,soloGranjero.maiz)) soloGranjero.maiz = 0;
            if (!EstadoGranja.igualSigno(soloGranjero.granjero,soloGranjero.zorro) && EstadoGranja.igualSigno(soloGranjero.gallina,soloGranjero.zorro)) soloGranjero.gallina = 0;
            successors.add(soloGranjero);
            if (EstadoGranja.igualSigno(s.granjero,s.zorro)) {
                    EstadoGranja aux = new EstadoGranja(s.granjero*-1,s.zorro*-1,s.gallina,s.maiz,s);
                    if (!EstadoGranja.igualSigno(aux.granjero,aux.gallina) && EstadoGranja.igualSigno(aux.gallina,aux.maiz)) aux.maiz = 0;
                    successors.add(aux);
            }
            if (EstadoGranja.igualSigno(s.granjero,s.gallina)) successors.add(new EstadoGranja(s.granjero*-1,s.zorro,s.gallina*-1,s.maiz,s));
            if (EstadoGranja.igualSigno(s.granjero,s.maiz)) {                    
                    EstadoGranja aux = new EstadoGranja(s.granjero*-1,s.zorro,s.gallina,s.maiz*-1,s);
                    if (!EstadoGranja.igualSigno(aux.granjero,aux.zorro) && EstadoGranja.igualSigno(aux.gallina,aux.zorro)) aux.gallina = 0;                    successors.add(aux);
                                }
                    
            return successors;
        }

        public boolean success(EstadoGranja s) {
            return (s.granjero<0 && s.zorro<0 && s.gallina<0 && s.maiz<0);
        }
        //le doy un estado y se fija q tan bueno es
        public int getValue(EstadoGranja s){
            return i;
        }
        public Comparator<S> getComparator(){
            Comparator<S> com = new Comparator<S>();

            return com;
        }
		

}
