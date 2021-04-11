package SistemasInteligentes;

import java.util.ArrayList;
import java.util.List;

public class listaAbiertos extends Abiertos{
    List<NodoAB> list;

    public listaAbiertos(){
        List<NodoAB> list = new ArrayList<>();
        this.list = list;
    }

    public List<NodoAB> getList() {
        return list;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void offer(int f, Estado estado) {
        NodoAB nodo = new NodoAB(f, estado);
        list.add(nodo);
        list.sort(NodoAB::compareTo);
    }

    @Override
    public Estado poll() {
        NodoAB x = list.get(0);
        list.remove(0);
        return x.getEstado();
    }

    @Override
    public void remove(Estado estado) {
        int i = 0;
        while (i < size() && !(list.get(i).getEstado().equals(estado))){
            i++;
        }
        if(i >= size()) {
            throw new RuntimeException("Estado no encontrado");
        }
        else {
            list.remove(i);
        }
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void ver() {
        for(NodoAB x : list){
            System.out.print(x.getF() + "|");
            x.getEstado().ver();
        }
    }
}
