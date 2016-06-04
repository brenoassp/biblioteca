package model;

/**
 *
 * @author anubis
 */
public class AlunoPosGraduacao extends Aluno{
    private String tipoDePos;

    public AlunoPosGraduacao() {}

    public AlunoPosGraduacao(String cpf, String nome, String dataNascimento, String endereco, 
            String telefone, String matricula, float notaProcessoSeletivo, String tipoDePos) {
        super(cpf, nome, dataNascimento, endereco, telefone, matricula, notaProcessoSeletivo);
        this.tipoDePos = tipoDePos;
    }

    public String getTipoDePos() {
        return tipoDePos;
    }

    public void setTipoDePos(String tipoDePos) {
        this.tipoDePos = tipoDePos;
    }
    
    
 }
