package SistemasInteligentes.GeneradorProblema;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueAbiertos extends Abiertos{
    PriorityQueue<NodoAB> queue;
    public PriorityQueueAbiertos(){
        PriorityQueue<NodoAB> q = new PriorityQueue();
        queue = q;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void offer(int f, Estado estado) {
        NodoAB nab = new NodoAB(f, estado);
        if (queue.isEmpty())
            queue.add(nab);
        else {
            queue.offer(nab);
        }
    }
    @Override
    public Estado poll() {
        NodoAB aux = queue.poll();
        return aux.getEstado();
    }

    @Override
    //Todo
    public void remove(Estado estado) {
        Iterator it = queue.iterator();
        int i = 0;
        while (it.hasNext() && !(it.equals(estado))){
            i++;
            it.next();
        }
        if(i>=queue.size()){
            System.out.println("No se encontro el elemento ");
            estado.ver();
        }else queue.remove(it);
    }

    @Override
    public int size() {
        int cont = 0;

        for(NodoAB x : queue){
            cont++;
        }
        return cont;
    }

    @Override
    public void ver() {
       for(NodoAB x : queue){
                System.out.print(x.getF() + "|");
                x.getEstado().ver();
       }

    }
}
