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
        return hashMap.containsKey(estado);
    }

    @Override
    public Nodo get(Estado estado) {
        return hashMap.get(estado);
    }

    @Override
    public void ver() {
        for(Estado x : hashMap.keySet()){
            x.ver();
        }
    }
}
