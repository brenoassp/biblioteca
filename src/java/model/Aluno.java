package model;

/**
 *
 * @author anubis
 */
public class Aluno extends Usuario{

    private float notaProcessoSeletivo;
    
    public Aluno() {}

    public Aluno(String cpf, String nome, String dataNascimento, String endereco, 
            String telefone, String matricula, float notaProcessoSeletivo) {
        super(cpf, nome, dataNascimento, endereco, telefone, matricula);
        this.notaProcessoSeletivo = notaProcessoSeletivo;
    }

    public float getNotaProcessoSeletivo() {
        return notaProcessoSeletivo;
    }

    public void setNotaProcessoSeletivo(float notaProcessoSeletivo) {
        this.notaProcessoSeletivo = notaProcessoSeletivo;
    }

 }
