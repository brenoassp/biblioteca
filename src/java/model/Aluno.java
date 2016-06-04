package model;

import java.sql.Date;

/**
 *
 * @author anubis
 */
public class Aluno extends Usuario{

    private float notaProcessoSeletivo;
    
    public Aluno() {}

    public Aluno(String cpf, String nome, String endereco, 
            String telefone, String matricula, float notaProcessoSeletivo, String senha) {
        super(cpf, nome, endereco, telefone, matricula, senha);
        this.notaProcessoSeletivo = notaProcessoSeletivo;
    }

    public float getNotaProcessoSeletivo() {
        return notaProcessoSeletivo;
    }

    public void setNotaProcessoSeletivo(float notaProcessoSeletivo) {
        this.notaProcessoSeletivo = notaProcessoSeletivo;
    }

 }
