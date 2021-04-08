package SistemasInteligentes;

import SistemasInteligentes.GeneradorProblema.*;

import java.util.Iterator;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(20, 5, 3, 4);
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
        int h = Estado.h(testf);
        lista.offer(h,Estado);

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

        Iterator it = lista.getList().iterator();



        Estado e1 = new EstadoMalla(campo,new Tuple(0,0));
        lista.offer(e1.h(testf),e1);
        lista.ver();
        System.out.println(); System.out.println(); System.out.println();
        System.out.println("Borramos el estado e1");
        lista.remove(e1);
        lista.ver();

    }
}
