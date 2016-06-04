package model;

import java.sql.Date;
import java.util.Observable;
import java.util.Observer;
import state.UsuarioEstado;

/**
 *
 * @author anubis
 */
public class Usuario extends Pessoa implements Observer{

    private String matricula;
    private UsuarioEstado estado;
    private String senha;
    
    public Usuario() {}

    public Usuario(String cpf, String nome, String endereco, 
            String telefone, String matricula, String senha) {
        super(cpf, nome, endereco, telefone);
        this.matricula = matricula;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public UsuarioEstado getEstado() {
        return estado;
    }

    public void setEstado(UsuarioEstado estado) {
        this.estado = estado;
    }
    

    @Override
    public void update(Observable o, Object arg) {
        // um livro com reserva foi devolvido
    }
    
    public boolean isFuncionario(){
        return false;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
 }
