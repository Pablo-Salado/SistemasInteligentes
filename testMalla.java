package SistemasInteligentes;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(1, 4, 4, 4);
        campo.ver();

        EstadoMalla test = new EstadoMalla(campo, campo.getPosI());
        System.out.println(test.calculaSucesores());
    }
}
