package SistemasInteligentes.GeneradorProblema;

import java.util.Collection;
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
        NodoAB nab = new NodoAB(f,estado);
        if(queue.isEmpty())
            queue.add(nab);
        else{
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
       while (it.hasNext() && !(it.equals(estado))){
           it.next();
       }
       if(it.equals(estado)){
            queue.remove(it);
       }
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void ver() {
        for (NodoAB x : queue) {
            System.out.print(x.getF() + "|");
            x.getEstado().ver();
        }
    }
}
