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
import model.Revista;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class RevistaDAO implements DAO<Revista>{
    
    private static final RevistaDAO instancia = new RevistaDAO();
    
    public static RevistaDAO getInstance(){
        return instancia;
    }

    @Override
    public List<Revista> getAll() {
        List<Revista> list = new ArrayList<Revista>();
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM (item_revista INNER JOIN"
                    + " item on item_revista.idrevista = item.iditem)";
            ResultSet rs = stmt.executeQuery(sql);            
            while(rs.next()){
                int idRevista  = rs.getInt("idrevista");;
                int numero = rs.getInt("numero");
                String titulo = rs.getString("titulo");
                String estado = rs.getString("estado");
                Revista revista;
                try {
                    revista = new Revista(idRevista, titulo, numero, estado);
                    list.add(revista);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(RevistaDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(RevistaDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(RevistaDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(RevistaDAO.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(RevistaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public Revista get(int id) {
        for(Revista revista : getAll()){
            if(revista.getId() == id){
                return revista;
            }
        }
        return null;
    }

    @Override
    public Revista get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Revista t) {
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
            //inserir revista
            sql = "INSERT INTO item_revista (idrevista, numero) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setInt(2, t.getNumero());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Revista t) {
        try {
            //update item
            String sql = "update item set titulo=?, estado=? where iditem=?";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setString(2, t.getNomeEstado());
            stmt.setInt(3, t.getId());
            stmt.execute();
            stmt.close();
            //update revista
            sql = "update item_revista set numero=? where idrevista=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getNumero());
            stmt.setInt(2, t.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Revista t) {
        //ItemDAO.getInstance().delete(t);
    }
    
}
