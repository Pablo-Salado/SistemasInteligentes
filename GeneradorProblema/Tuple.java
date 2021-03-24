package SistemasInteligentes.GeneradorProblema;

public class Tuple {
         int fila;
         int columna;

        public Tuple(int A, int B){
            fila=A;
            columna = B;
        }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    @Override
        public String toString() {
            return "Coords{" +
                    "fila=" + fila +
                    ", columna=" + columna +
                    '}';
        }
}
