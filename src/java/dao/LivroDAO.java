/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Livro;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class LivroDAO implements DAO<Livro>{
    
    private static final LivroDAO instancia = new LivroDAO();
    
    public static LivroDAO getInstance(){
        return instancia;
    }

    @Override
    public List<Livro> getAll() {
        List<Livro> list = new ArrayList<Livro>();
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM (item_livroDidatico INNER JOIN "
                    + " item on item_livroDidatico.idlivroDidatico = item.iditem)";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int idLivro  = rs.getInt("idlivroDidatico");;
                String titulo = rs.getString("titulo");
                String editora = rs.getString("editora");
                String ISBN = rs.getString("ISBN");
                String estado = rs.getString("estado");
                Livro livro;
                try {
                    livro = new Livro(idLivro, titulo, ISBN, editora, estado);
                    list.add(livro);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Livro get(int id) {
        for(Livro livro : getAll()){
            if(livro.getId() == id){
                return livro;
            }
        }
        return null;
    }

    @Override
    public Livro get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Livro t) {
        PreparedStatement stmt;
        try {
            //inserir item
            String sql = "INSERT INTO item (iditem, titulo) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getTitulo());
            stmt.execute();
            stmt.close();
            //inserir livro
            sql = "INSERT INTO item_livrodidatico (idlivroDidatico, ISBN, editora) "
                    + "values (?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getISBN());
            stmt.setString(3, t.getEditora());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Livro t) {
        try {
            //update item
            String sql = "update item set titulo=?, estado=? where iditem=?";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setString(2, t.getNomeEstado());
            stmt.setInt(3, t.getId());
            stmt.execute();
            stmt.close();
            //update livro
            sql = "update item_livrodidatico set ISBN=?, editora=? where idlivroDidatico=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getISBN());
            stmt.setString(2, t.getEditora());
            stmt.setInt(3, t.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Livro t) {
        //ItemDAO.getInstance().delete(t);
    }
    
}
