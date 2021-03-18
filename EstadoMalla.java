package SistemasInteligentes;

import java.util.ArrayList;
import java.util.List;

public class EstadoMalla implements Estado{

    private static Malla malla;
    private char estado;
    private Tuple posicion;

    public EstadoMalla(Tuple pos, char est){
        posicion = pos;
        estado = est;
    }

    @Override
    public List<? extends Estado> calculaSucesores() {
        List<EstadoMalla> estado = new ArrayList<>();
        int cont = 0;
        EstadoMalla sucesorActual = new EstadoMalla(malla.getPosI(), 'A');
        sucesorActual.posicion.asign(malla.getPosI().fila - 1, malla.getPosI().columna);

        while(cont < 4){
            //asignar a sucesorActual el siguiente posible sucesor
            //para hacer eso tener en cuenta q tenemos q llegar a las posiciones (-1,0) (1,0) (0,-1) (0,1)
            if(InMalla(sucesorActual) && esHueco(sucesorActual)){ //si está en la malla y es un hueco
                estado.add(sucesorActual); //añadirlo a la lista de estados
            }
            cont++; //o esta fuera de la matriz o es un obstaculo por tanto no se considera sucesor

        }
        return estado;
    }

    private boolean InMalla(EstadoMalla sucesor) {
        return sucesor.posicion.fila >= 0 && sucesor.posicion.fila < malla.getFilas() && sucesor.posicion.columna >= 0 && sucesor.posicion.columna < malla.getColumnas();
    }

    private boolean esHueco (EstadoMalla sucesor) {
        char[][] matriz;
        matriz = malla.getgMatrix();
        return matriz[sucesor.posicion.fila][sucesor.posicion.columna] == '-';
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

