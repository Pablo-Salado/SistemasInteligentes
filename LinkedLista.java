package SistemasInteligentes;

import java.util.LinkedList;

public class LinkedLista<E> extends Arbol{

    LinkedList<Nodo> lista = new LinkedList();

    //Introduce el nodo n en el arbol
    @Override
    public void put(Nodo nodo) {
        lista.add(nodo);
    }

    //True si e arbol contiene el estado indicado, false en otro caso
    @Override
    public boolean containsKey(Estado estado) {
        int i = 0;

        boolean res = false;
        while(i < lista.size() && !res){
            if(lista.get(i).e.equals(estado))
                res = true;
            else
                i++;
        }
        return res;
    }

    //Devolvera el nodo asociado al estado e en el arbol
    @Override
    public Nodo get(Estado estado) {
        int i = 0;
        boolean res = false;
        Nodo resNodo = null;
        while(i < lista.size() && !res) {

            if (lista.get(i).e.equals(estado)) {
                resNodo = lista.get(i);
                res = true;
            } else {
                i++;
            }
        }
        return resNodo;
    }

    //Imprime el contenido de la lista
    @Override
    public void ver() {
        for(Nodo x : lista){
            x.getEstado().ver();
        }

    }
}