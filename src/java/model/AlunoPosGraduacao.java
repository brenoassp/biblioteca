package model;

/**
 *
 * @author anubis
 */
public class AlunoPosGraduacao extends Aluno{
    private String tipoDePos;

    public AlunoPosGraduacao() {}

    public AlunoPosGraduacao(String cpf, String nome, String endereco, 
            String telefone, String matricula, float notaProcessoSeletivo, 
            String tipoDePos, String senha) {
        super(cpf, nome, endereco, telefone, matricula, notaProcessoSeletivo, senha);
        this.tipoDePos = tipoDePos;
    }

    public String getTipoDePos() {
        return tipoDePos;
    }

    public void setTipoDePos(String tipoDePos) {
        this.tipoDePos = tipoDePos;
    }
    
    
 }
