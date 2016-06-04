package model;

/**
 *
 * @author anubis
 */
public class AlunoGraduacao extends Aluno{
    private String modoIngresso;

    public AlunoGraduacao() {}

    public AlunoGraduacao(String cpf, String nome, String endereco, 
            String telefone, String matricula, float notaProcessoSeletivo, 
            String modoIngresso, String senha) {
        super(cpf, nome, endereco, telefone, matricula, notaProcessoSeletivo, senha);
        this.modoIngresso = modoIngresso;
    }

    public String getModoIngresso() {
        return modoIngresso;
    }

    public void setModoIngresso(String modoIngresso) {
        this.modoIngresso = modoIngresso;
    }

 }
