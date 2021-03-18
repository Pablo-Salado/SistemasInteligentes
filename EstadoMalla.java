package SistemasInteligentes;

import java.util.ArrayList;
import java.util.List;

public class EstadoMalla implements Estado{

    static Malla matriz;

    public EstadoMalla(Malla mat){
        matriz = mat;
    }

    @Override
    public List<? extends Estado> calculaSucesores() {
        List<Estado> estado = new ArrayList<>();
        int cont = 0;
        Tuple sucesorActual = matriz.getPosI();

        while(cont < 4){
            //asignar a sucesorActual el primer posible sucesor
            if(InMalla(sucesorActual) && esHueco(sucesorActual)){ //si está en la malla y es un hueco
                estado.add(sucesorActual); //añadirlo a la lista de estados
                cont++;
            }else{
                //o esta fuera de la matriz o es un obstaculo por tanto no se considera sucesor
            }
        }
        return estado;
    }

    private boolean InMalla(Tuple posI) {
        return posI.fila >= 0 && posI.fila < matriz.getFilas() && posI.columna >= 0 && posI.columna < matriz.getColumnas();
    }

    private boolean esHueco (Tuple sucesor) {
        return false;
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

