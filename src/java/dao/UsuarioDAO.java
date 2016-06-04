/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import action.LoginAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import persistencia.DatabaseLocator;

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
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Usuario t) {
        
    }

    @Override
    public void update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario get(int id) {
        
        return null;
    }

    @Override
    public Usuario get(String matricula) {
        try {
            Connection conn = DatabaseLocator.getConnection();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

//try {
//    Connection conn = DatabaseLocator.getConnection();
//
//} catch (SQLException | ClassNotFoundException ex) {
//    Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
//}