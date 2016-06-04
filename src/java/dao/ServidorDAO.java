package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Servidor;
import persistencia.DatabaseLocator;

/**
 *
 * @author anubis
 */
public class ServidorDAO implements DAO<Servidor>{
    
    private static final ServidorDAO instancia = new ServidorDAO();
    
    public static ServidorDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<Servidor> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM ((servidor INNER JOIN "
                    + " usuario on servidor.matricula = usuario.matricula)"
                    + "INNER JOIN pessoa on usuario.cpf = pessoa.cpf)";
            ResultSet rs = stmt.executeQuery(sql);
            List<Servidor> list = new ArrayList<Servidor>();
            while(rs.next()){
                String matricula = rs.getString("matricula");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                Servidor servidor = new Servidor(cpf, nome, endereco, 
                                            telefone, matricula, senha);
                list.add(servidor);
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
    public void insert(Servidor t) {
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
            //inserir servidor
            sql = "INSERT INTO servidor (matricula) "
                    + "values (?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Servidor t) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Servidor t) {
        //PessoaDAO.getInstance().delete(t);
    }

    @Override
    public Servidor get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servidor get(String id) {
        for(Servidor servidor : getAll()){
            if(servidor.getMatricula().equals(id)){
                return servidor;
            }
        }
        return null;
    }
    
}
