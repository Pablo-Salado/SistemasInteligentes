package SistemasInteligentes;

import SistemasInteligentes.GeneradorProblema.Estado;
import SistemasInteligentes.GeneradorProblema.EstadoMalla;
import SistemasInteligentes.GeneradorProblema.Malla;
import SistemasInteligentes.GeneradorProblema.Tuple;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(20, 5, 3, 4);
        campo.ver();
        System.out.println("La posición inicial es: " + campo.getPosI());
        System.out.println("La posición final es: " + campo.getPosF());

        EstadoMalla test = new EstadoMalla(campo,campo.getPosI());
        EstadoMalla testf = new EstadoMalla(campo, campo.getPosF());
        for(Estado x:test.calculaSucesores()){
            x.ver();
            System.out.println(x.h(test));
            if(test.equals(x)){
                System.out.println("Igual");
            }else{
                System.out.println("Diferente");
            }
        }

    }
}
