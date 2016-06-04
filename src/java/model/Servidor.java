package model;

/**
 *
 * @author anubis
 */
public class Servidor extends Usuario{

    public Servidor() {}

    public Servidor(String cpf, String nome, String dataNascimento, String endereco, 
            String telefone, String matricula) {
        super(cpf, nome, dataNascimento, endereco, telefone, matricula);
    }
    
 }
