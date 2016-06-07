/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Aluno;
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Funcionario;
import model.Reserva;
import model.Servidor;
import model.Usuario;

/**
 *
 * @author breno
 */
public class UsuarioDAO implements DAO<Usuario>{

    private static final UsuarioDAO instancia = new UsuarioDAO();
    
    public static UsuarioDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<Usuario> getAll() {
        List<Usuario> list = new ArrayList<>();
        for(Aluno aluno : AlunoDAO.getInstance().getAll()){
            list.add(aluno);
        }
        for(Funcionario funcionario : FuncionarioDAO.getInstance().getAll()){
            list.add(funcionario);
        }
        for(Servidor servidor : ServidorDAO.getInstance().getAll()){
            list.add(servidor);
        }
        for(Usuario user: list){
            List<Reserva> userReservas = ReservaDAO.getInstance().getReservasUsuario(user.getMatricula());
            user.setReservas(userReservas);
        }
        return list;
    }

    @Override
    public void insert(Usuario t) {
        if(t instanceof AlunoGraduacao){
            AlunoGraduacaoDAO.getInstance().insert((AlunoGraduacao)t);
        }else if(t instanceof AlunoPosGraduacao){
            AlunoPosGraduacaoDAO.getInstance().insert((AlunoPosGraduacao)t);
        }else if(t instanceof Funcionario){
            FuncionarioDAO.getInstance().insert((Funcionario)t);
        }else if(t instanceof Servidor){
            ServidorDAO.getInstance().insert((Servidor)t);
        }
    }

    @Override
    public void update(Usuario t) {
        if(t instanceof AlunoGraduacao){
            AlunoGraduacaoDAO.getInstance().update((AlunoGraduacao)t);
        }else if(t instanceof AlunoPosGraduacao){
            AlunoPosGraduacaoDAO.getInstance().update((AlunoPosGraduacao)t);
        }else if(t instanceof Funcionario){
            FuncionarioDAO.getInstance().update((Funcionario)t);
        }else if(t instanceof Servidor){
            ServidorDAO.getInstance().update((Servidor)t);
        }
    }

    @Override
    public void delete(Usuario t) {
        PessoaDAO.getInstance().delete(t);
    }

    @Override
    public Usuario get(int id) {
        
        return null;
    }

    @Override
    public Usuario get(String id) {
        for(Usuario usuario : getAll()){
            if(usuario.getMatricula().equals(id)){
                return usuario;
            }
        }
        return null;
    }
    
}