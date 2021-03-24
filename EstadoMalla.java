package SistemasInteligentes;

import java.util.ArrayList;
import java.util.List;

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

        Tuple sup =posicion;
        sup.asign(sup.fila-1, sup.columna);
        Tuple inf=posicion;
        inf.asign(inf.fila+1, inf.columna);
        Tuple der=posicion;
        der.asign(der.fila,der.columna+1);
        Tuple izq=posicion;
        izq.asign(izq.fila,izq.columna+1);

        if(esHueco(sup) && InMalla(sup)) {
            EstadoMalla superior = new EstadoMalla(malla, sup);
            estados.add(superior);
        }else if(esHueco(inf) && InMalla(inf)){
            EstadoMalla inferior = new EstadoMalla(malla, inf);
            estados.add(inferior);
        }else if(esHueco(der) && InMalla(der)){
            EstadoMalla derecha = new EstadoMalla(malla, der);
            estados.add(derecha);
        }else if (esHueco(izq) && InMalla(izq)){
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
        return matriz[sucesor.fila][sucesor.columna] == '-';
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

