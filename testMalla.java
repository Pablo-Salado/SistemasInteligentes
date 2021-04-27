package SistemasInteligentes;

import SistemasInteligentes.GeneradorProblema.*;
import SistemasInteligentes.GeneradorProblema.Arbol;

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
      /*
        System.out.println("Prueba PriorityQueue");

        PriorityQueueAbiertos queueAbiertos = new PriorityQueueAbiertos();
        queueAbiertos.offer(2,test);
        queueAbiertos.ver();
        queueAbiertos.remove(test);


        queueAbiertos.offer(19,test);
        queueAbiertos.offer(12,test);
        queueAbiertos.offer(1,test);

        queueAbiertos.offer(7,test);
        queueAbiertos.offer(e1.h(testf),e1);
        queueAbiertos.ver();


        if(queueAbiertos.isEmpty())
            System.out.println("Esta vacia");
        else System.out.println("No esta vacia");

        System.out.println(queueAbiertos.size());
        queueAbiertos.ver();
*/
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba LinkedLista");

        Arbol<Estado> arbol = new LinkedLista<Estado>();
        Nodo n = new Nodo(testf, 0, null);
        Nodo n2 = new Nodo(e1, e1.h(testf), null);

        arbol.put(n);
        arbol.put(n2);

        if(arbol.containsKey(borrar1))
            System.out.println("Esta dentro pishita");
        else
            System.out.println("Esto no furula");




        arbol.ver();






    }
}
