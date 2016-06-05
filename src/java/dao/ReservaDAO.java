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
import model.Reserva;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class ReservaDAO implements DAO<Reserva>{
    private static final ReservaDAO instancia = new ReservaDAO();
    
    public static ReservaDAO getInstance(){
        return instancia;
    }

    @Override
    public List<Reserva> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM reserva";
            ResultSet rs = stmt.executeQuery(sql);
            List<Reserva> list = new ArrayList<Reserva>();
            while(rs.next()){
                String matriculaUsuario = rs.getString("matriculaUsuario");
                int iditem = rs.getInt("iditem");
                int posicao = rs.getInt("posicao");
                Reserva reserva = new Reserva(matriculaUsuario, iditem, posicao);
                list.add(reserva);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Reserva t) {
        PreparedStatement stmt;
        try {
            //inserir reserva
            String sql = "INSERT INTO reserva (matriculaUsuario, iditem, "
                    + "posicao) values (?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getMatriculaUsuario());
            stmt.setInt(2, t.getIditem());
            stmt.setInt(3, t.getPosicao());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Reserva t) {
        try {
            //update reserva
            String sql = "update reserva set posicao=? where ( (matriculaUsuario=?) "
                    + "AND (iditem=?) )";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);   
            stmt.setInt(1, t.getPosicao());
            stmt.setString(2, t.getMatriculaUsuario());
            stmt.setInt(3, t.getIditem());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Reserva t) {
        try {
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement("delete" +
                    "from reserva where ( (matriculaUsuario=?) AND (iditem=?) )");
            stmt.setInt(1, t.getPosicao());
            stmt.setString(2, t.getMatriculaUsuario());
            stmt.setInt(3, t.getIditem());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
