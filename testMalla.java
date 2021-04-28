package SistemasInteligentes;

import SistemasInteligentes.GeneradorProblema.*;

import java.util.Iterator;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(90, 5, 3, 4);
        campo.ver();
        System.out.println("La posición inicial es: " + campo.getPosI());
        System.out.println("La posición final es: " + campo.getPosF());

        EstadoMalla testf = new EstadoMalla(campo, campo.getPosF());
        EstadoMalla test = new EstadoMalla(campo,campo.getPosI());

       /* for(Estado x:test.calculaSucesores()){
            x.ver();
            System.out.println(x.h(test));
            if(test.equals(x)){
                System.out.println("Igual");
            }else{
                System.out.println("Diferente");
            }
        }*/

        AbiertosLista lista = new AbiertosLista();
        if(lista.isEmpty())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
        EstadoMalla Estado = new EstadoMalla(campo, campo.getPosI());

        Estado w = (EstadoMalla) testf;

        if(lista.isEmpty())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");

        for(Estado x : test.calculaSucesores()){
            lista.offer(x.h(testf),x);
            if(x.equals(w))
                System.out.println("Iguales");
            else System.out.println("Distintos");
        }

        lista.ver();

        Estado borrar1 = lista.poll();
        Estado borrar2 = lista.poll();

        System.out.print("Vamos a borrar el estado:");
        borrar1.ver();

        System.out.print("Vamos a borrar el estado:");
        borrar2.ver();

        lista.ver();
        System.out.println(); System.out.println(); System.out.println();
        System.out.println("Insertamos el estado e1");

        Estado e1 = new EstadoMalla(campo,new Tuple(0,0));
        lista.offer(e1.h(testf),e1);
        lista.ver();
        System.out.println(); System.out.println(); System.out.println();
        System.out.println("Borramos el estado e1");
        lista.remove(e1);
        lista.ver();
        System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println("Prueba Equals()");

        if(e1.equals(new EstadoMalla(campo,new Tuple(0,0))))
            System.out.println("Son el mismo");
        else{
            System.out.println("no lo son");
        }


        System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println("Prueba PriorityQueue");

        PriorityQueueAbiertos queueAbiertos = new PriorityQueueAbiertos();

        queueAbiertos.offer(e1.h(testf),e1);


        if(queueAbiertos.isEmpty())
            System.out.println("Esta vacia");
        else System.out.println("No esta vacia");
        System.out.println();System.out.println();System.out.println();System.out.println();
        queueAbiertos.ver();

        queueAbiertos.remove(e1);

        System.out.println(queueAbiertos.size());

        System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println("Prueba Hito 4");

        Nodo<Estado> n1 = new Nodo<>(e1,e1.h(testf),null);
        Nodo<Estado> n2 = new Nodo<>(test,test.h(testf),null);
        Nodo<Estado> n3 = new Nodo<>(testf,testf.h(testf),null);
        Estado w1 = new EstadoMalla(campo,new Tuple(2,1));


        HashMapL<Estado> mapL = new HashMapL<>();
        mapL.put(n1);
        mapL.put(n2);
        mapL.ver();


    }
}
