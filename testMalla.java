package SistemasInteligentes;

import java.util.Iterator;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(1, 4, 4, 4);
        campo.ver();

        EstadoMalla estadoInicial = new EstadoMalla(campo, campo.getPosI());
        EstadoMalla estadoFinal = new EstadoMalla(campo, campo.getPosF());

        for(Estado estadoActual:estadoInicial.calculaSucesores()){
            estadoActual.ver();
            System.out.println(estadoActual.h(estadoFinal));
            if(estadoFinal.equals(estadoActual)){
                System.out.println("Igual");
            }else{
                System.out.println("Diferente");
            }
        }
        System.out.println();
        System.out.println("Distancia Manhattan desde el inicio al final");
        System.out.println(estadoInicial.h(estadoFinal));
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

        for(Estado x : estadoInicial.calculaSucesores()){
            lista.offer(x.h(estadoFinal),x);                //ver con el depurador que hace esto
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
        lista.offer(e1.h(estadoFinal),e1);
        lista.ver();
        System.out.println(); System.out.println(); System.out.println();
        System.out.println("Borramos el estado e1");
        lista.remove(e1);
        lista.ver();

    }
}
