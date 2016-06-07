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
import model.Periodico;
import model.Revista;
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
        List<Item> list = new ArrayList<>();
        for(Livro livro : LivroDAO.getInstance().getAll()){
            list.add(livro);
        }
        for(Periodico periodico : PeriodicoDAO.getInstance().getAll()){
            list.add(periodico);
        }
        for(Revista revista : RevistaDAO.getInstance().getAll()){
            list.add(revista);
        }
        for(Item i : list)
            System.out.println(i.getTitulo());
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
            String sql = "INSERT INTO item (iditem, titulo, estado) values (?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getId());
            stmt.setString(2, t.getTitulo());
            stmt.setString(3, t.getNomeEstado());
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
            String sql = "UPDATE item SET titulo=?, estado=? WHERE iditem=?";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setString(1, t.getTitulo());
            stmt.setString(2, t.getNomeEstado());
            stmt.setInt(3, t.getId());
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
