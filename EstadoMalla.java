package SistemasInteligentes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L.Mandow
 * @date  2021-03-11
 *
 * Plantilla para representar los estados de la pr�ctica
 *
 */

public class EstadoMalla implements Estado{

    private static Malla malla;
    private Tuple posicion;

    public EstadoMalla(Malla mall, Tuple pos){
        malla = mall;
        posicion = pos;
    }

    @Override
    public List<? extends Estado> calculaSucesores() {
        List<EstadoMalla> estados = new ArrayList<>();

        Tuple sup = new Tuple(posicion.fila, posicion.columna);
        sup.asign(sup.fila-1, sup.columna);
        if(InMalla(sup) && esHueco(sup)){
            EstadoMalla superior = new EstadoMalla(malla, sup);
            estados.add(superior);
        }

        Tuple inf = new Tuple(posicion.fila, posicion.columna);
        inf.asign(inf.fila+1, inf.columna);
        if(InMalla(inf) && esHueco(inf)){
            EstadoMalla inferior = new EstadoMalla(malla, inf);
            estados.add(inferior);
        }

        Tuple der = new Tuple(posicion.fila, posicion.columna);
        der.asign(der.fila, der.columna+1);
        if(InMalla(der) && esHueco(der)){
            EstadoMalla derecha = new EstadoMalla(malla, der);
            estados.add(derecha);
        }

        Tuple izq = new Tuple(posicion.fila, posicion.columna);
        izq.asign(izq.fila, izq.columna-1);
        if(InMalla(izq) && esHueco(izq)){
            EstadoMalla izquierda = new EstadoMalla(malla, izq);
            estados.add(izquierda);
        }

        return estados;
    }

    private boolean InMalla(Tuple sucesor) {
        return sucesor.fila >= 0 && sucesor.fila < malla.getFilas()
                && sucesor.columna >= 0 && sucesor.columna < malla.getColumnas();
    }

    private boolean esHueco (Tuple sucesor) {
        char[][] matriz;
        matriz = malla.getgMatrix();
        return matriz[sucesor.fila][sucesor.columna] == '-' || matriz[sucesor.fila][sucesor.columna] == 'F';
    }

    @Override
    public int coste(Estado e2) {
        return 1;
    }

    @Override
    public int h(Estado objetivo) {
        return Math.abs(posicion.fila - ((EstadoMalla) objetivo).posicion.fila) +
                Math.abs(posicion.columna - ((EstadoMalla) objetivo).posicion.columna);
    }

    @Override
    public void ver() {
        System.out.println(posicion.toString());
    }

    @Override
    public boolean equals(Estado obj) {
        EstadoMalla e2 = (EstadoMalla) obj;
        return posicion.fila == e2.posicion.fila && posicion.columna == e2.posicion.columna;
    }


    public int hashCode(){
        return 0;
    }

}

