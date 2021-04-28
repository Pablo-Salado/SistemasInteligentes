package SistemasInteligentes;

public class testAgenteA {
    public static void main(String [] args) {
        long res = 0;

        System.out.println("---------------------------------------------------------------");
        System.out.println("Prueba AgenteA");
        System.out.println();
        Malla campo = new Malla(43, 8, 5, 10);
        campo.ver();

        EstadoMalla estadoInicial = new EstadoMalla(campo, campo.getPosI());
        EstadoMalla estadoFinal = new EstadoMalla(campo, campo.getPosF());

        long start = System.currentTimeMillis();

        AgenteA agenteA = new AgenteA();
        for(Estado x : agenteA.resuelve(estadoInicial, estadoFinal)){
            x.ver();
        }

        long end = System.currentTimeMillis();
        res = end - start;
        System.out.println(res);
    }
}
