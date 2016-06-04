package model;

import java.sql.Date;

/**
 *
 * @author anubis
 */
public class Funcionario extends Usuario{
    private String clt;
    
    public Funcionario() {}

    public Funcionario(String cpf, String nome, String endereco, 
            String telefone, String matricula, String senha, String clt) {
        super(cpf, nome, endereco, telefone, matricula, senha);
        this.clt = clt;
    }

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    
 }
