/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import strategy.EmprestimoConsulta;
import strategy.TipoEmprestimo;

/**
 *
 * @author breno
 */
public class Emprestimo {
    
    private int idemprestimo;
    private String matriculaUsuario;
    private int iditem;
    private Calendar dataEmprestimo;
    private Calendar dataDevolucao;
    private Calendar dataEntrega;
    private TipoEmprestimo tipo;

    public int getIdemprestimo() {
        return idemprestimo;
    }

    public void setIdemprestimo(int idemprestimo) {
        this.idemprestimo = idemprestimo;
    }

    public String getMatriculaUsuario() {
        return matriculaUsuario;
    }

    public void setMatriculaUsuario(String matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
    }

    public Calendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Calendar dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public Emprestimo(int idemprestimo, String matriculaUsuario, int iditem,
            Calendar dataEmprestimo, Calendar dataDevolucao, 
            Calendar dataEntrega){
        this.idemprestimo = idemprestimo;
        this.matriculaUsuario = matriculaUsuario;
        this.iditem = iditem;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.dataEntrega = dataEntrega;
        this.tipo = new EmprestimoConsulta();
    }
    
    public Emprestimo(){}
    
    public float getMulta(int numeroDias){
        return tipo.calculaMulta(numeroDias);
    }
}
