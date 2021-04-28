package SistemasInteligentes.GeneradorProblema;

import java.util.HashMap;

public class HashMapL<E> extends Arbol {
    HashMap<Estado,Nodo> map = new HashMap();

    @Override
    public void put(Nodo nodo) {
       map.put(nodo.getEstado(), nodo);
    }

    @Override
    public boolean containsKey(Estado estado) {
        return map.containsKey(estado);
    }

    @Override
    public Nodo get(Estado estado) {
        return map.get(estado);
    }

    @Override
    public void ver() {
       for(Estado x : map.keySet()){
           x.ver();
       }
    }
}