package SistemasInteligentes;

public class testAgenteA {
    public static void main(String [] args) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba AgenteA");
        System.out.println();
        Malla campo = new Malla(43, 8, 5, 5);
        campo.ver();

        EstadoMalla estadoInicial = new EstadoMalla(campo, campo.getPosI());
        EstadoMalla estadoFinal = new EstadoMalla(campo, campo.getPosF());

        AgenteA agenteA = new AgenteA();
        for(Estado x : agenteA.resuelve(estadoInicial, estadoFinal)){
            x.ver();
        }
        System.out.print("time in seconds = ");
        System.out.println(System.nanoTime() * 0.000000001);
    }
}
