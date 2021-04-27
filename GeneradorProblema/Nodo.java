package SistemasInteligentes.GeneradorProblema;

public  class Nodo<E extends Estado>{
    E e;
    int g;
    Nodo<E> padre = null;

    public Nodo(E e, int g, Nodo<E> padre){
        this.e = e;           // Estado
        this.g = g;          //g(estado)
        this.padre = padre; //Padre
    }

    public E getEstado() {
        return this.e;
    }

    public int getG() {
        return this.g;
    }

    public Nodo<E> getPadre() {
        return this.padre;
    }

    public void setPadre(Nodo<E> p) {
        this.padre = p;
    }

    public void setG(int g) {
        this.g = g;
    }

    public String toString() {
        return  e.toString() + " (" + this.g + ") ";
    }

}