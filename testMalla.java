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


        if(lista.isEmpty())
            System.out.println("TRUE");
        else
            System.out.println("FALSE");

        for(Estado x : test.calculaSucesores()){
            lista.offer(x.h(testf),x);
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
        Estado e2 = new EstadoMalla(campo,new Tuple(3,1));
        lista.offer(e1.h(testf),e1);
        lista.ver();
        System.out.println(); System.out.println(); System.out.println();
        System.out.println("Borramos el estado e1");
        lista.remove(e1);
        lista.ver();

        System.out.println();System.out.println();System.out.println();System.out.println();
        System.out.println("Prueba PriorityQueue");

        PriorityQueueAbiertos queueAbiertos = new PriorityQueueAbiertos();

        queueAbiertos.offer(e1.h(testf), e1);
        System.out.println("Hemos insertado e1");
        System.out.println();
        queueAbiertos.ver();
        queueAbiertos.offer(borrar1.h(testf), borrar1);
        System.out.println("Hemos insertado borrar1");
        System.out.println();
        queueAbiertos.ver();
        queueAbiertos.offer(borrar2.h(testf), borrar2);
        System.out.println("Hemos insertado borrar2");
        queueAbiertos.ver();
        System.out.println();
        queueAbiertos.offer(e2.h(testf), e2);
        System.out.println("Hemos insertado e2");
        System.out.println();
        queueAbiertos.ver();



        queueAbiertos.poll();
        System.out.println("Hemos hecho un poll");
        queueAbiertos.ver();

        if(queueAbiertos.isEmpty())
            System.out.println("La cola esta vacia");
        else System.out.println("La cola no esta vacia");



    }
}
