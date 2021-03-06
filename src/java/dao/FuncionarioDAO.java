package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import persistencia.DatabaseLocator;

/**
 *
 * @author anubis
 */
public class FuncionarioDAO implements DAO<Funcionario>{
    
    private static FuncionarioDAO instancia = new FuncionarioDAO();
    
    public static FuncionarioDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<Funcionario> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM ((funcionario INNER JOIN "
                    + " usuario on funcionario.matricula = usuario.matricula)"
                    + "INNER JOIN pessoa on usuario.cpf = pessoa.cpf)";
            ResultSet rs = stmt.executeQuery(sql);
            List<Funcionario> list = new ArrayList<Funcionario>();
            while(rs.next()){
                String matricula = rs.getString("matricula");
                String clt = rs.getString("clt");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                Funcionario funcionario = new Funcionario(cpf, nome, endereco, 
                                            telefone, matricula, senha, clt);
                list.add(funcionario);
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
    public void insert(Funcionario t) {
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
            //inserir funcionario
            sql = "INSERT INTO funcionario (matricula, clt) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatricula());
            stmt.setString(2, t.getClt());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Funcionario t) {
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
            //update funcionario
            sql = "update funcionario set clt=? where matricula=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getClt());
            stmt.setString(2, t.getMatricula());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Funcionario t) {
        PessoaDAO.getInstance().delete(t);
    }

    @Override
    public Funcionario get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario get(String id) {
        for(Funcionario funcionario : getAll()){
            if(funcionario.getMatricula().equals(id)){
                return funcionario;
            }
        }
        return null;
    }
    
}
