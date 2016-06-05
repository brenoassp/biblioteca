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
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Item;
import model.Livro;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class ItemDAO implements DAO<Item>{
    
    private static final ItemDAO instancia = new ItemDAO();
    
    public static ItemDAO getInstance(){
        return instancia;
    }

    @Override
    public List<Item> getAll() {
        Statement stmt;
        List<Item> list = new ArrayList<>();
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM item";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int iditem  = rs.getInt("iditem");
                String titulo = rs.getString("titulo");
                Item item = new Item(iditem, titulo);
                list.add(item);
            }
            return list;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Item get(int id) {
        for(Item item : getAll()){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public Item get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Item t) {
        PreparedStatement stmt;
        try {
            //inserir item
            String sql = "INSERT INTO item (iditem, titulo) values (?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getTitulo());
            stmt.execute();
            stmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Item t) {
        PreparedStatement stmt;
        try {
            //update item
            String sql = "UPDATE item SET titulo=? WHERE iditem=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setInt(2, t.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Item t) {
        //ItemDAO.getInstance().delete(t);
    }
    
    public List<Item> search(String term){
        List<Item> itemsSearched = new ArrayList<>();
        for(Item i: getAll()){
            if(i.getTitulo().contains(term))
                itemsSearched.add(i);
        }
        return itemsSearched;
    }
    
}
