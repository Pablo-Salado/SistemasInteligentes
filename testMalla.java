package SistemasInteligentes;

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
    }
}
