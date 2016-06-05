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
import model.Multa;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class MultaDAO implements DAO<Multa>{

    private static final MultaDAO instancia = new MultaDAO();
    
    public static MultaDAO getInstance(){
        return instancia;
    }
    
    @Override
    public List<Multa> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM multa";
            ResultSet rs = stmt.executeQuery(sql);
            List<Multa> list = new ArrayList<Multa>();
            while(rs.next()){
                int idemprestimo  = rs.getInt("idemprestimo");;
                String matriculaUsuario = rs.getString("matriculaUsuario");
                double valor = rs.getDouble("valor");
                Multa multa = new Multa(idemprestimo, matriculaUsuario, valor);
                list.add(multa);
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
    public Multa get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Multa get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Multa t) {
        PreparedStatement stmt;
        try {
            //inserir multa
            String sql = "INSERT INTO multa (idemprestimo, matriculaUsuario, "
                    + "valor) values (?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getIdemprestimo());
            stmt.setString(2, t.getMatriculaUsuario());
            stmt.setDouble(3, t.getValor());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Multa t) {
        try {
            //update multa
            String sql = "update multa set valor=? where ( (matriculaUsuario=?) AND (idemprestimo=?) )";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);   
            stmt.setDouble(1, t.getValor());
            stmt.setString(2, t.getMatriculaUsuario());
            stmt.setInt(3, t.getIdemprestimo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Multa t) {
        try {
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement("delete" +
                    "from multa where ( (matriculaUsuario=?) AND (idemprestimo=?) )");
            stmt.setString(1, t.getMatriculaUsuario());
            stmt.setInt(2, t.getIdemprestimo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
