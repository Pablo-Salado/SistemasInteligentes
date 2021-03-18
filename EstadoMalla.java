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

        while(cont < 4){
                if(OutOfMatrix(matriz.posI)){
                        cont++;
                }else{

                }

        }


        return estado;
    }

    private boolean OutOfMatrix(Tuple posI) {
        return posI.fila >= 0 && posI.fila < matriz.gFilas && posI.columna >= 0 && posI.columna < matriz.gColumnas;
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
