package SistemasInteligentes.GeneradorProblema;

import java.util.LinkedList;

public class LinkedLista<E> extends Arbol{

    LinkedList<Nodo> lista = new LinkedList();

    //Introduce el nodo n en el arbol
    @Override
    public void put(Nodo nodo) {

        if(lista.isEmpty()){ //Ponemos el padre
            lista.add(nodo);
            nodo.setPadre(nodo);
        }else{ //Tenemos que insertar el elemento
                lista.add(nodo);



        }


    }

    //True si e arbol contiene el estado indicado, false en otro caso
    @Override
    public boolean containsKey(Estado estado) {
        return false;
    }

    //Devolvera el nodo asociado al estado e en el arbol
    @Override
    public Nodo get(Estado estado) {
        return null;
    }

    //Imprime el contenido de la lista
    @Override
    public void ver() {
        for(Nodo x : lista){
            x.getEstado().ver();
        }

    }
}
