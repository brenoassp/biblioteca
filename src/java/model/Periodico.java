package model;

/**
 *
 * @author anubis
 */
public class Periodico extends Item{
    private String localPublicacao;

    public Periodico() {}

    public Periodico(int id, String titulo, String localPublicacao) {
        super(id, titulo);;
        this.localPublicacao = localPublicacao;
    }

    public String getLocalPublicacao() {
        return localPublicacao;
    }

    public void setLocalPublicacao(String localPublicacao) {
        this.localPublicacao = localPublicacao;
    }

    
       
}
