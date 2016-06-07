package model;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author anubis
 */
public class Livro extends Item{
    private String ISBN;
    private String titulo;
    private String editora;

    public Livro() {}

    public Livro(int id, String titulo, String ISBN, String editora, String estado) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(id, titulo, estado);
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
       
    
}
