/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AlunoPosGraduacao;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class AlunoPosGraduacaoDAO implements DAO<AlunoPosGraduacao>{

    private static final AlunoPosGraduacaoDAO instancia = new AlunoPosGraduacaoDAO();
    
    public static AlunoPosGraduacaoDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<AlunoPosGraduacao> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM ((aluno_posgraduacao INNER JOIN "
                    + " aluno on aluno_posgraduacao.matricula = aluno.matricula)"
                    + "INNER JOIN usuario on aluno_posgraduacao.matricula = usuario.matricula)"
                    + "INNER JOIN pessoa on usuario.cpf = pessoa.cpf";
            ResultSet rs = stmt.executeQuery(sql);
            List<AlunoPosGraduacao> list = new ArrayList<AlunoPosGraduacao>();
            while(rs.next()){
                String matricula  = rs.getString("matricula");;
                String tipoDePos = rs.getString("tipoDePos");
                float notaProcessoSeletivo = rs.getFloat("notaProcessoSeletivo");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                AlunoPosGraduacao aluno = new AlunoPosGraduacao(cpf, nome, endereco, 
                                            telefone, matricula, notaProcessoSeletivo, 
                                            tipoDePos, senha);
                list.add(aluno);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoPosGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoPosGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AlunoPosGraduacao t) {
        try {
            //update pessoa
            String sql = "update pessoa set nome=?, endereco=?, telefone=?" +
             " where cpf=?";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getEndereco());
            stmt.setString(3, t.getTelefone());
            stmt.setString(4, t.getCpf());
            stmt.execute();
            stmt.close();
            //update usuario
            sql = "update usuario set cpf=?, senha=? where matricula=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getCpf());
            stmt.setString(2, t.getSenha());
            stmt.setString(3, t.getMatricula());
            stmt.execute();
            stmt.close();
            //update aluno
            sql = "update aluno set notaProcessoSeletivo=? where matricula=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setFloat(1, t.getNotaProcessoSeletivo());
            stmt.setString(2, t.getMatricula());
            stmt.execute();
            stmt.close();
            //update aluno_graduacao
            sql = "update aluno_posgraduacao set tipoDePos=? where matricula=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getTipoDePos());
            stmt.setString(2, t.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoPosGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(AlunoPosGraduacao t) {
        //PessoaDAO.getInstance().delete(t);
    }

    @Override
    public AlunoPosGraduacao get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlunoPosGraduacao get(String matricula) {
        for(AlunoPosGraduacao aluno : getAll()){
            if(aluno.getMatricula().equals(matricula)){
                return aluno;
            }
        }
        return null;
    }

    @Override
    public void insert(AlunoPosGraduacao t) {
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
            //inserir aluno de posGraduacao
            sql = "INSERT INTO aluno_posgraduacao (matricula, tipoDePos) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatricula());
            stmt.setString(2, t.getTipoDePos());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoPosGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoPosGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}