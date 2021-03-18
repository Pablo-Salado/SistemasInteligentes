package SistemasInteligentes;

import java.util.Random;

public class Malla {
    private final int gFilas;
    private final int gColumnas;
    private final int gObstaculos;
    private char[][] gMatrix;

    private Tuple posI;
    private Tuple posF;

    public Malla(long seed, int filas, int columnas, int obstaculos) {
        Random S = new Random();
        S.setSeed(seed);

        gFilas = filas;
        gColumnas = columnas;
        gObstaculos = obstaculos;

        gMatrix = iniMatrix();
        generarObstaculos(S);
        generarInicioyFinal(S);

    }

    public void generarObstaculos(Random seed) {
        for (int i = 0; i < gObstaculos; i++) {
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
        boolean ini = false;
        boolean check = false;
        while(!check) {
            if (!ocupada(rndFila, rndColumna) && ini) {
                gMatrix[rndFila][rndColumna] = 'F';
                posF = new Tuple(rndFila,rndColumna);
                check = true;
            }else if(!ocupada(rndFila, rndColumna) && !ini){
                gMatrix[rndFila][rndColumna] = 'I';
                posI = new Tuple(rndFila,rndColumna);
                ini = true;
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

    public int getFilas() {
        return gFilas;
    }

    public int getColumnas() {
        return gColumnas;
    }

    public int getObstaculos() {
        return gObstaculos;
    }

    public Tuple getPosI() {
        return posI;
    }

    public Tuple getPosF() {
        return posF;
    }
}



