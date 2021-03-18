package SistemasInteligentes;

import java.util.ArrayList;
import java.util.List;

public class EstadoMalla implements Estado{

    static Malla malla;

    public EstadoMalla(Malla mat){
        malla = mat;
    }

    @Override
    public List<? extends Estado> calculaSucesores() {
        List<Estado> estado = new ArrayList<>();
        int cont = 0;
        Tuple sucesorActual = malla.getPosI();
        sucesorActual.asign(malla.getPosI().fila + 1, malla.getPosI().columna);

        while(cont < 4){
            //asignar a sucesorActual el siguiente posible sucesor
            if(InMalla(sucesorActual) && esHueco(sucesorActual)){ //si está en la malla y es un hueco
                estado.add(sucesorActual); //añadirlo a la lista de estados

            }
            cont++; //o esta fuera de la matriz o es un obstaculo por tanto no se considera sucesor

        }
        return estado;
    }

    private boolean InMalla(Tuple posI) {
        return posI.fila >= 0 && posI.fila < malla.getFilas() && posI.columna >= 0 && posI.columna < malla.getColumnas();
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

