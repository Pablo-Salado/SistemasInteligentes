package SistemasInteligentes.GeneradorProblema;

import java.util.ArrayList;
import java.util.List;

public class EstadoMalla implements Estado{

    static Malla matriz;

    public EstadoMalla(Malla mat){
        matriz = mat;
    }

    @Override
    public List<? extends Estado> calculaSucesores() {
        return null;
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
