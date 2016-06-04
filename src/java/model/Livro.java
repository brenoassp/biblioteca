package model;

/**
 *
 * @author anubis
 */
public class Livro extends Item{
    private int ISBN;
    private String titulo;
    private String editora;

    public Livro() {}

    public Livro(int id, String titulo, int ISBN, String editora) {
        super(id, titulo);
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editora = editora;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
       
}
