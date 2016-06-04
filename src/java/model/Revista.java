package model;

/**
 *
 * @author anubis
 */
public class Revista extends Item{
    private int numero;

    public Revista() {}

    public Revista(int id, String titulo, int numero) {
        super(id, titulo);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
       
}
