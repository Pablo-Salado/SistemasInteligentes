package SistemasInteligentes;

import SistemasInteligentes.GeneradorProblema.EstadoMalla;
import SistemasInteligentes.GeneradorProblema.Malla;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(1, 3, 5, 4);

        campo.ver();
        System.out.println("La posición inicial es: " + campo.getPosI());
        System.out.println("La posición final es: " + campo.getPosF());

        EstadoMalla m= new EstadoMalla(campo);
    }
}
