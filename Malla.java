package SistemasInteligentes;

import java.util.List;
import java.util.Random;

public class Malla{
    final int gFilas;
    final int gColumnas;
    char[][] gMatrix;
    Tuple posI;
    Tuple posF;



    public Malla(long seed, int filas, int columnas, int obstaculos) {
        Random S = new Random();
        S.setSeed(seed);

        gFilas = filas;
        gColumnas = columnas;

        gMatrix = iniMatrix();
        generarObstaculos(S,obstaculos);
        generarInicioyFinal(S);

    }

    public char[][] getgMatrix() {
        return gMatrix;
    }
    public Tuple getPosI() {
        return posI;
    }

    public Tuple getPosF() {
        return posF;
    }

    public void generarObstaculos(Random seed, int obstaculos) {
        for (int i = 0; i < obstaculos; i++) {
            int filaObstaculo = seed.nextInt(gFilas);
            int columnaObstaculo = seed.nextInt(gColumnas);
            while(ocupada(filaObstaculo, columnaObstaculo)){
                filaObstaculo = seed.nextInt(gFilas);
                columnaObstaculo = seed.nextInt(gColumnas);
            }
            gMatrix[filaObstaculo][columnaObstaculo] = 'X';
        }
    }

    public void generarInicioyFinal (Random seed) {
        int rndFila = seed.nextInt(gFilas);
        int rndColumna = seed.nextInt(gColumnas);
        boolean ini = false,check = false;
        while(!check) {
            if (!ocupada(rndFila, rndColumna) && ini) {
                gMatrix[rndFila][rndColumna] = 'F';
                check = true;
                posF = new Tuple(rndFila,rndColumna);
            }else if(!ocupada(rndFila, rndColumna) && !ini){
                gMatrix[rndFila][rndColumna] = 'I';
                ini = true;
                posI = new Tuple(rndFila,rndColumna);
            }else{
                rndFila = seed.nextInt(gFilas);
                rndColumna = seed.nextInt(gColumnas);
            }
        }
    }


    private boolean ocupada (int fila, int columna) {
        return gMatrix[fila][columna] != '-';
    }

    private char[][] iniMatrix() {
        char [][] aux;
        aux = new char[gFilas][gColumnas];

        for(int i = 0; i < gFilas; i++){
            for(int j = 0; j < gColumnas;j++){
                aux[i][j] = '-';
            }
        }
        return aux;
    }

    public void ver(){
        for(int i = 0; i < gFilas; i++){
            for(int j = 0; j < gColumnas;j++){
                System.out.print(gMatrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

}