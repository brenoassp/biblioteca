package model;

/**
 *
 * @author anubis
 */
public class AlunoGraduacao extends Aluno{
    private String modoIngresso;

    public AlunoGraduacao() {}

    public AlunoGraduacao(String cpf, String nome, String dataNascimento, String endereco, 
            String telefone, String matricula, float notaProcessoSeletivo, String modoIngresso) {
        super(cpf, nome, dataNascimento, endereco, telefone, matricula, notaProcessoSeletivo);
        this.modoIngresso = modoIngresso;
    }

    public String getModoIngresso() {
        return modoIngresso;
    }

    public void setModoIngresso(String modoIngresso) {
        this.modoIngresso = modoIngresso;
    }

 }
