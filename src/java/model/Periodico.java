package model;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author anubis
 */
public class Periodico extends Item{
    private String localPublicacao;

    public Periodico() {}

    public Periodico(int id, String titulo, String localPublicacao, String estado) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(id, titulo, estado);
        this.localPublicacao = localPublicacao;
    }

    public String getLocalPublicacao() {
        return localPublicacao;
    }

    public void setLocalPublicacao(String localPublicacao) {
        this.localPublicacao = localPublicacao;
    }

    
       
}
