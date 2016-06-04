package model;

/**
 *
 * @author anubis
 */
public class Servidor extends Usuario{

    public Servidor() {}

    public Servidor(String cpf, String nome, String endereco, 
            String telefone, String matricula, String senha) {
        super(cpf, nome, endereco, telefone, matricula, senha);
    }
    
 }
