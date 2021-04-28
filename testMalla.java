package SistemasInteligentes;

import java.util.Iterator;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(90, 5, 3, 4);
        campo.ver();
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba EstadoMalla");
        System.out.println();

        EstadoMalla estadoInicial = new EstadoMalla(campo, campo.getPosI());
        EstadoMalla estadoFinal = new EstadoMalla(campo, campo.getPosF());

        for(Estado estadoActual:estadoInicial.calculaSucesores()){
            estadoActual.ver();
            System.out.println(estadoActual.h(estadoFinal));
            if(estadoActual.equals(estadoFinal)){
                System.out.println("Igual");
            }else{
                System.out.println("Diferente");
            }
        }
        System.out.println();
        System.out.println("Distancia Manhattan desde el inicio al final");
        System.out.println(estadoInicial.h(estadoFinal));
        System.out.println();

        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba listaAbiertos");
        System.out.println();

        listaAbiertos lista = new listaAbiertos();

        if(lista.isEmpty()){
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }

        int h = estadoInicial.h(estadoFinal);
        lista.offer(h,estadoFinal);

        if(lista.isEmpty())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");

        lista.poll(); //borra el primer elemento de la lista

        for(Estado x : estadoInicial.calculaSucesores()){
            lista.offer(x.h(estadoFinal),x);
        }

        System.out.println();
        campo.ver();
        lista.ver();
        System.out.println();

        /*
        Estado borrar1 = lista.poll();
        Estado borrar2 = lista.poll();

        System.out.print("Vamos a borrar el estado:");
        borrar1.ver();

        System.out.print("Vamos a borrar el estado:");
        borrar2.ver();
    */
        System.out.println();
        lista.ver();
        System.out.println();
        System.out.println("Insertamos el estado e1");

        Estado e1 = new EstadoMalla(campo,new Tuple(0,0));
        lista.offer(e1.h(estadoFinal),e1);
        lista.ver();
        System.out.println();
        System.out.println("Borramos el estado e1");
        lista.remove(e1);
        lista.ver();

        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba PriorityQueue");
        System.out.println();

        PriorityQueueAbiertos queueAbiertos = new PriorityQueueAbiertos();

        queueAbiertos.offer(2,estadoInicial);
        queueAbiertos.offer(19,estadoInicial);
        queueAbiertos.offer(12,estadoInicial);
        queueAbiertos.offer(1,estadoInicial);

        queueAbiertos.offer(7,estadoInicial);
        queueAbiertos.offer(e1.h(estadoFinal),e1);

        if(queueAbiertos.isEmpty())
            System.out.println("Esta vacia");
        else System.out.println("No esta vacia");

        System.out.println(queueAbiertos.size());
        queueAbiertos.ver();

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba LinkedLista");
        System.out.println();

        Arbol<Estado> arbol = new LinkedLista<Estado>();
        Nodo n = new Nodo(estadoFinal, 0, null);
        Nodo n2 = new Nodo(e1, e1.h(estadoFinal), null);

        arbol.put(n);
        arbol.put(n2);

        if(arbol.containsKey(estadoFinal))
            System.out.println("Esta dentro");
        else
            System.out.println("Esto fuera");

        arbol.ver();

        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba HashMap");
        System.out.println();

        Arbol<Estado> arbol1 = new HashMapL<Estado>();

        arbol1.put(n);
        arbol1.put(n2);

        if(arbol1.containsKey(estadoFinal))
            System.out.println("Esta dentro");
        else
            System.out.println("Esto fuera");

        arbol1.ver();
    }
}
