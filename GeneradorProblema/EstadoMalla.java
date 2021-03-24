package SistemasInteligentes.GeneradorProblema;

import java.util.ArrayList;
import java.util.List;

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

        Tuple sup = actual;
        sup.setFila(sup.fila-1);
        Tuple inf=actual;
        inf.setFila(inf.fila+1);
        Tuple der=actual;
        der.setColumna(der.columna+1);
        Tuple izq=actual;
        izq.setColumna(izq.columna+1);

        if(esValida(sup)) {
            EstadoMalla superior = new EstadoMalla(matriz, sup);
            estados.add(superior);
        }else if(esValida(inf)){
            EstadoMalla inferior = new EstadoMalla(matriz, inf);
            estados.add(inferior);
        }else if(esValida(der)){
            EstadoMalla derecha = new EstadoMalla(matriz, der);
            estados.add(derecha);
        }else if (esValida(izq)){
            EstadoMalla izquierda = new EstadoMalla(matriz, izq);
            estados.add(izquierda);
        }

        return estados;
    }

    private boolean esValida(Tuple tuple) {
        return ((tuple.fila>=0 && tuple.fila<=matriz.gFilas) && (tuple.columna>=0 && tuple.columna<=matriz.gColumnas)) && (matriz.gMatrix[tuple.fila][tuple.columna] =='-');
    }

    @Override
    public int coste(Estado e2) {
        return 0;
    }

    @Override
    public int h(Estado objetivo) {
        return 0;
    }

    @Override
    public void ver() {

    }

    public boolean equals(){
       return false;
    }

    public int hashCode(){
        return 0;
    }

}
