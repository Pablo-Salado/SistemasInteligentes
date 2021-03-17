package SistemasInteligentes;

public class testMalla {

    public static void main(String [] args) {
        Malla campo = new Malla(1, 3, 5, 4);

        campo.ver();
        System.out.println(campo.getPosI());
        System.out.println(campo.getPosF());
    }
}
