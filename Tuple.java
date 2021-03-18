package SistemasInteligentes;

public class Tuple {
    final int fila;
    final int columna;

    public Tuple(int A, int B){
        fila=A;
        columna = B;
    }

    @Override
    public String toString() {
        return "Coords{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }
}
