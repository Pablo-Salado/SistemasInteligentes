package SistemasInteligentes;

import java.util.HashMap;

public class HashMapL<E> extends Arbol{
    HashMap<Estado, Nodo> hashMap = new HashMap();

    @Override
    public void put(Nodo nodo) {
        hashMap.put(nodo.getEstado(), nodo);
    }

    @Override
    public boolean containsKey(Estado estado) {
        return false;
    }

    @Override
    public Nodo get(Estado estado) {
        return null;
    }

    @Override
    public void ver() {

    }
}
