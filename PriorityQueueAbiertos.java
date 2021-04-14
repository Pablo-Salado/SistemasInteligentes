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

    }

    @Override
    public Estado poll() {
        Estado aux = (Estado) queue.poll();
        queue.poll(); //borratodo
        return aux;
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
        return 0;
    }

    @Override
    public void ver() {

    }
}
