package SistemasInteligentes.GeneradorProblema;

import java.util.HashMap;

public class HashMapL<Estado> extends Arbol {
    HashMap<Nodo,Integer> map = new HashMap();

    @Override
    public void put(Nodo nodo) {
        map.put(nodo,nodo.getG());
    }

    @Override
    public boolean containsKey(SistemasInteligentes.GeneradorProblema.Estado estado) {
        return false;
    }

    @Override
    public Nodo get(SistemasInteligentes.GeneradorProblema.Estado estado) {
        return null;
    }

    @Override
    public void ver() {

    }
}
