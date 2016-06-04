package model;

import java.sql.Date;

/**
 *
 * @author anubis
 */
public class Funcionario extends Pessoa{
    private String clt;
    private String matricula;
    
    public Funcionario() {}

    public Funcionario(String cpf, String nome, String endereco, 
            String telefone, String matricula) {
        super(cpf, nome, endereco, telefone);
        this.matricula = matricula;
        this.clt = clt;
    }

    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
 }
