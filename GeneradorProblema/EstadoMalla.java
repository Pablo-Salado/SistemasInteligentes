package SistemasInteligentes.GeneradorProblema;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstadoMalla implements Estado{

    static Malla matriz;
    Tuple inicio;
    Tuple fin;
    Tuple actual;

    public EstadoMalla(Malla mat,Tuple actual){
        matriz = mat;
        inicio = mat.getPosI();
        fin = mat.getPosF();
        this.actual = actual;
    }


    @Override
    public List<? extends Estado> calculaSucesores() {
        List<EstadoMalla> estados = new ArrayList<>();

        int filaActual = actual.getFila(), columnaActual = actual.getColumna();

        Tuple sup = new Tuple(filaActual,columnaActual);
        sup.setFila(sup.getFila()-1);
        if(esValidaEnMatriz(sup)) {
            EstadoMalla superior = new EstadoMalla(matriz, sup);
            estados.add(superior);
        }

        Tuple inf=new Tuple(filaActual,columnaActual);
        inf.setFila(inf.getFila()+1);
        if(esValidaEnMatriz(inf)) {
            EstadoMalla inferior = new EstadoMalla(matriz, inf);
            estados.add(inferior);
        }
        Tuple der=new Tuple(filaActual,columnaActual);
        der.setColumna(actual.columna+1);
        if(esValidaEnMatriz(der)){
                EstadoMalla derecha = new EstadoMalla(matriz, der);
                estados.add(derecha);
        }

        Tuple izq=new Tuple(filaActual,columnaActual);
        izq.setColumna(actual.columna-1);
        if (esValidaEnMatriz(izq)){
            EstadoMalla izquierda = new EstadoMalla(matriz, izq);
            estados.add(izquierda);
        }
        return estados;
    }


    private boolean esValidaEnMatriz(Tuple tuple) {
        return ((tuple.fila>=0 && tuple.fila<matriz.gFilas) && (tuple.columna>=0 && tuple.columna<matriz.gColumnas)) && (matriz.gMatrix[tuple.getFila()][tuple.getColumna()] == '-' || matriz.gMatrix[tuple.getFila()][tuple.getColumna()] == 'F');
    }

    @Override
    public int coste(Estado e2) {
        return 1;
    }

    @Override
    public int h(Estado objetivo) {
        EstadoMalla aux = (EstadoMalla) objetivo;
        return Math.abs(actual.fila - aux.actual.fila) + Math.abs(actual.columna - aux.actual.columna);
    }

    @Override
    public void ver() {
        System.out.println(actual.toString());
    }

    @Override
    public boolean equals(Estado o) {
        EstadoMalla e2 = (EstadoMalla) o;
        if (e2 == null || getClass() != e2.getClass()) return false;
        return (this.actual.getColumna() == e2.actual.getColumna() && this.actual.getFila() == e2.actual.getFila());
    }

    @Override
    public int hashCode() {
        return Objects.hash(inicio, fin, actual);
    }
}
