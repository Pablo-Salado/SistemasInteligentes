package SistemasInteligentes;

import SistemasInteligentes.AlgoritmoBusqueda.AgenteA;
import SistemasInteligentes.GeneradorProblema.Estado;
import SistemasInteligentes.GeneradorProblema.EstadoMalla;
import SistemasInteligentes.GeneradorProblema.Malla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestAgenteA {


    public static void main(String [] args){
        long start = System.currentTimeMillis();
        Malla campo = new Malla(6, 5, 3, 4);
        campo.ver();

        EstadoMalla Inicio = new EstadoMalla(campo,campo.getPosI());
        EstadoMalla Final = new EstadoMalla(campo,campo.getPosF());
        AgenteA solucionador = new AgenteA();
        List<Estado> x = solucionador.resuelve(Inicio,Final);

        Collections.reverse(x);
        System.out.println("El agente A comienza en ");

        Iterator<Estado> it = x.iterator();
        it.next().ver();
        System.out.println("Y continua por");
        int first=0;
        for(Estado w: x){
            if(first==0){
                first++;
            }else {
                if(w.equals(Final)){
                    w.ver();
                    System.out.println("Ha llegado al final");
                }else {
                    w.ver();
                }
            }
        }
        long end = System.currentTimeMillis();
        long res = end - start;

        System.out.println("Tiempo necesario = "+res+"ms");


    }


}
