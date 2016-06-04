/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Funcionario;
import model.Servidor;
import model.Pessoa;
import model.Usuario;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class PessoaDAO implements DAO<Pessoa>{

    private static final PessoaDAO instancia = new PessoaDAO();
    
    public static PessoaDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<Pessoa> getAll() {
        List<Pessoa> list = new ArrayList<>();
        for(Usuario usuario : UsuarioDAO.getInstance().getAll()){
            list.add(usuario);
        }
        return list;
    }

    @Override
    public void insert(Pessoa t) {
        if(t instanceof AlunoGraduacao){
            AlunoGraduacaoDAO.getInstance().insert((AlunoGraduacao)t);
        }else if(t instanceof AlunoPosGraduacao){
            AlunoPosGraduacaoDAO.getInstance().insert((AlunoPosGraduacao)t);
        }else if(t instanceof Funcionario){
            FuncionarioDAO.getInstance().insert((Funcionario)t);
        }else if(t instanceof Servidor){
            ServidorDAO.getInstance().insert((Servidor)t);
        }else if(t instanceof Usuario){
            UsuarioDAO.getInstance().insert((Usuario)t);
        }
    }

    @Override
    public void update(Pessoa t) {
        if(t instanceof AlunoGraduacao){
            AlunoGraduacaoDAO.getInstance().update((AlunoGraduacao)t);
        }else if(t instanceof AlunoPosGraduacao){
            AlunoPosGraduacaoDAO.getInstance().update((AlunoPosGraduacao)t);
        }else if(t instanceof Funcionario){
            FuncionarioDAO.getInstance().update((Funcionario)t);
        }else if(t instanceof Servidor){
            ServidorDAO.getInstance().update((Servidor)t);
        }else if(t instanceof Usuario){
            UsuarioDAO.getInstance().update((Usuario)t);
        }
    }

    @Override
    public void delete(Pessoa t) {
        try {
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement("delete" +
                    "from pessoa where cpf=?");
            stmt.setString(1, t.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pessoa get(int id) {
        
        return null;
    }

    @Override
    public Pessoa get(String id) {
        for(Pessoa pessoa : getAll()){
            if(pessoa.getCpf().equals(id)){
                return pessoa;
            }
        }
        return null;
    }
    
}