/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import action.LoginAction;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlunoGraduacao;
import model.Usuario;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class AlunoGraduacaoDAO implements DAO<AlunoGraduacao>{

    private static final AlunoGraduacaoDAO instancia = new AlunoGraduacaoDAO();
    
    public static AlunoGraduacaoDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<AlunoGraduacao> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM ((aluno_graduacao INNER JOIN "
                    + " aluno on aluno_graduacao.matricula = aluno.matricula)"
                    + "INNER JOIN usuario on aluno_graduacao.matricula = usuario.matricula)"
                    + "INNER JOIN pessoa on usuario.cpf = pessoa.cpf";
            ResultSet rs = stmt.executeQuery(sql);
            List<AlunoGraduacao> list = new ArrayList<AlunoGraduacao>();
            while(rs.next()){
                String matricula  = rs.getString("matricula");;
                String modoDeIngresso = rs.getString("modoDeIngresso");
                float notaProcessoSeletivo = rs.getFloat("notaProcessoSeletivo");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                AlunoGraduacao aluno = new AlunoGraduacao(cpf, nome, endereco, 
                                            telefone, matricula, notaProcessoSeletivo, 
                                            modoDeIngresso, senha);
                list.add(aluno);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AlunoGraduacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AlunoGraduacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoGraduacao get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoGraduacao get(String matricula) {
        for(AlunoGraduacao aluno : getAll()){
            if(aluno.getMatricula().equals(matricula)){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public void insert(AlunoGraduacao t) {
        PreparedStatement stmt;
        try {
            //inserir pessoa
            String sql = "INSERT INTO pessoa (cpf, nome, endereco, telefone) "
                    + "values (?,?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getCpf());
            stmt.setString(2, t.getNome());
            stmt.setString(3, t.getEndereco());
            stmt.setString(4, t.getTelefone());
            stmt.execute();
            stmt.close();
            //inserir usuario
            sql = "INSERT INTO usuario (matricula, cpf, senha) "
                    + "values (?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatricula());
            stmt.setString(2, t.getCpf());
            stmt.setString(3, t.getSenha());
            stmt.execute();
            stmt.close();
            //inserir aluno
            sql = "INSERT INTO aluno (matricula, notaProcessoSeletivo) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatricula());
            stmt.setFloat(2, t.getNotaProcessoSeletivo());
            stmt.execute();
            stmt.close();
            //inserir aluno de graduacao
            sql = "INSERT INTO aluno_graduacao (matricula, modoDeIngresso) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatricula());
            stmt.setString(2, t.getModoIngresso());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}