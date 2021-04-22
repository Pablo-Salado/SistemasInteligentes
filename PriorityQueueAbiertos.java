package SistemasInteligentes;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueAbiertos extends Abiertos{
    PriorityQueue queue;

    public PriorityQueueAbiertos(){
        PriorityQueue q = new PriorityQueue();
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
        NodoAB aux = (NodoAB) queue.poll();
        return aux.getEstado();
    }

    @Override
    public void remove(Estado estado) {
        Iterator it = queue.iterator();
        int i = 0;
        while (it.hasNext() && !(it.equals(estado))){
            i++;
            it.next();
        }
        if(i>=queue.size()){
            throw new RuntimeException("Estado no encontrado");
        }else queue.remove(it);
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
