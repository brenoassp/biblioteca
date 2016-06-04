package model;

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
    
    public Usuario() {}

    public Usuario(String cpf, String nome, String dataNascimento, String endereco, 
            String telefone, String matricula) {
        super(cpf, nome, dataNascimento, endereco, telefone);
        this.matricula = matricula;
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
    
 }
