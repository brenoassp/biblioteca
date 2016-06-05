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
import model.Periodico;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class PeriodicoDAO implements DAO<Periodico>{
    
    private static final PeriodicoDAO instancia = new PeriodicoDAO();
    
    public static PeriodicoDAO getInstance(){
        return instancia;
    }

    @Override
    public List<Periodico> getAll() {
        Statement stmt;
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM ((item_periodico INNER JOIN "
                    + " item on item_periodico.idperiodico = item.iditem)";
            ResultSet rs = stmt.executeQuery(sql);
            List<Periodico> list = new ArrayList<Periodico>();
            while(rs.next()){
                int idPeriodico  = rs.getInt("idperiodico");;
                String titulo = rs.getString("titulo");
                String localPublicacao = rs.getString("localPublicacao");
                Periodico periodico = new Periodico(idPeriodico, titulo, localPublicacao);
                list.add(periodico);
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
    public Periodico get(int id) {
        for(Periodico periodico : getAll()){
            if(periodico.getId() == id){
                return periodico;
            }
        }
        return null;
    }

    @Override
    public Periodico get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Periodico t) {
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
            //inserir periodico
            sql = "INSERT INTO item_periodico (idperiodico, localPublicacao) "
                    + "values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getLocalPublicacao());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Periodico t) {
        try {
            //update item
            String sql = "update item set titulo=? where iditem=?";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setInt(2, t.getId());
            stmt.execute();
            stmt.close();
            //update periodico
            sql = "update item_periodico set localPublicacao=? where idperiodico=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getLocalPublicacao());
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
    public void delete(Periodico t) {
        //ItemDAO.getInstance().delete(t);
    }
    
}
