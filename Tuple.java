package SistemasInteligentes;

public class Tuple {
    public int fila;
    public int columna;

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

    public void asign (int filaNueva, int columnaNueva) {
        fila = filaNueva;
        columna = columnaNueva;
    }
}
