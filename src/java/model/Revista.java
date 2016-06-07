package model;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author anubis
 */
public class Revista extends Item{
    private int numero;

    public Revista() {}

    public Revista(int id, String titulo, int numero, String estado) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(id, titulo, estado);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
       
}
