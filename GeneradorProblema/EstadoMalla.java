package SistemasInteligentes.GeneradorProblema;

import java.util.ArrayList;
import java.util.List;

public class EstadoMalla implements Estado{

    static Malla matriz;
    Tuple inicio;
    Tuple fin;
    Tuple actual;

    public EstadoMalla(Malla mat,Tuple actual){
        matriz = mat;
        inicio = mat.getPosI();
        fin = mat.getPosF();
        this.actual = actual;
    }


    @Override
    public List<? extends Estado> calculaSucesores() {

    }

    @Override
    public int coste(Estado e2) {
        return 0;
    }

    @Override
    public int h(Estado objetivo) {
        return 0;
    }

    @Override
    public void ver() {

    }

    public boolean equals(){
       return false;
    }

    public int hashCode(){
        return 0;
    }

}
