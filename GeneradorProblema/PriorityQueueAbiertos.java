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

        NodoAB nodo = new NodoAB(f,estado);

            queue.offer(nodo);

    }

    @Override
    public Estado poll() {
        NodoAB aux = queue.poll();
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
        return 0;
    }

    @Override
    public void ver() {
       for(NodoAB x : queue){
                System.out.print(x.getF() + "|");
                x.getEstado().ver();
       }

    }
}
