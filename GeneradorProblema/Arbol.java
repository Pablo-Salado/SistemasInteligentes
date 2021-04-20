package SistemasInteligentes.GeneradorProblema;

public abstract class Arbol<E extends Estado> {
    public abstract void put(NodoAB nodo);

    public abstract boolean constainsKey(E estado);

    public abstract NodoAB get(E estado);

    public abstract void ver();
}
