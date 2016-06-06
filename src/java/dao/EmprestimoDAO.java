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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Emprestimo;
import persistencia.DatabaseLocator;

/**
 *
 * @author breno
 */
public class EmprestimoDAO implements DAO<Emprestimo>{
    
    private static final EmprestimoDAO instancia = new EmprestimoDAO();
    
    public static EmprestimoDAO getInstance(){
        return instancia;
    }

    @Override
    public List<Emprestimo> getAll() {
        Statement stmt;
        List<Emprestimo> list = new ArrayList<>();
        try {
            stmt = DatabaseLocator.getConnection().createStatement();
            String sql = "SELECT * FROM emprestimo";
            ResultSet rs = stmt.executeQuery(sql);  
            while(rs.next()){
                int idemprestimo  = rs.getInt("idemprestimo");;
                String matriculaUsuario = rs.getString("matriculaUsuario");
                int iditem = rs.getInt("iditem");
                Calendar dataEmprestimo = Calendar.getInstance();
                dataEmprestimo.setTime(rs.getDate("dataEmprestimo"));
                Calendar dataDevolucao = Calendar.getInstance();
                dataDevolucao.setTime(rs.getDate("dataDevolucao"));
                Calendar dataEntrega = null;
                if(rs.getDate("dataEntrega") != null){
                    dataEntrega = Calendar.getInstance();
                    dataEntrega.setTime(rs.getDate("dataEntrega"));
                }
                Emprestimo emprestimo = new Emprestimo(idemprestimo, matriculaUsuario,
                                            iditem, dataEmprestimo, dataDevolucao,
                                            dataEntrega);
                list.add(emprestimo);
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Emprestimo> getEmprestimosUsuario(String matricula) {
        List<Emprestimo> emprestimos = new ArrayList<>();
        for(Emprestimo emprestimo: getAll()){
            if(emprestimo.getMatriculaUsuario().equals(matricula))
                emprestimos.add(emprestimo);
        }
        return emprestimos;
    }
    
    public List<Emprestimo> getEmprestimosPendentesUsuario(String matricula) {
        List<Emprestimo> emprestimos = new ArrayList<>();
        for(Emprestimo emprestimo: getAll()){
            if(emprestimo.getMatriculaUsuario().equals(matricula) && emprestimo.getDataEntrega() == null)
                emprestimos.add(emprestimo);
        }
        return emprestimos;
        
    }


    @Override
    public Emprestimo get(int id) {
        for(Emprestimo emprestimo : getAll()){
            if(emprestimo.getIdemprestimo() == id){
                return emprestimo;
            }
        }
        return null;
    }

    @Override
    public Emprestimo get(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Emprestimo t) {
        PreparedStatement stmt;
        try {
            //inserir emprestimo
            String sql = "INSERT INTO emprestimo (idemprestimo, matriculaUsuario, "
                    + "iditem, dataEmprestimo, dataDevolucao, dataEntrega) "
                    + "values (?,?,?,?,?,?)";
            stmt = DatabaseLocator.getConnection().prepareStatement(sql);
            stmt.setInt(1, t.getIdemprestimo());
            stmt.setString(2, t.getMatriculaUsuario());
            stmt.setInt(3, t.getIditem());
            stmt.setDate(4, new java.sql.Date(t.getDataEmprestimo().getTimeInMillis()));
            stmt.setDate(5, new java.sql.Date(t.getDataDevolucao().getTimeInMillis()));
            stmt.setDate(6, new java.sql.Date(t.getDataEntrega().getTimeInMillis()));
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Emprestimo t) {
        try {
            //update emprestimo
            String sql = "update emprestimo set matriculaUsuario=?, iditem=?, "
                    + "dataEmprestimo=?, dataDevolucao=?, dataEntrega=?" +
             " where idemprestimo=?";
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement(sql);   
            stmt.setString(1, t.getMatriculaUsuario());
            stmt.setInt(2, t.getIditem());
            stmt.setDate(3, new java.sql.Date(t.getDataEmprestimo().getTimeInMillis()));
            stmt.setDate(4, new java.sql.Date(t.getDataDevolucao().getTimeInMillis()));
            stmt.setDate(5, new java.sql.Date(t.getDataEntrega().getTimeInMillis()));
            stmt.setInt(6, t.getIdemprestimo());
            stmt.execute();
            stmt.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoGraduacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Emprestimo t) {
        try {
            PreparedStatement stmt = DatabaseLocator.getConnection().prepareStatement("delete" +
                    "from emprestimo where idemprestimo=?");
            stmt.setInt(1, t.getIdemprestimo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmprestimoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
