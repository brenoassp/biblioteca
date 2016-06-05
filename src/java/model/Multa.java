/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author breno
 */
public class Multa {
    private int idemprestimo;
    private String matriculaUsuario;
    private double valor;
    
    public Multa(){}
    
    public Multa(int idemprestimo, String matriculaUsuario, double valor){
        this.idemprestimo = idemprestimo;
        this.matriculaUsuario = matriculaUsuario;
        this.valor = valor;
    }

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
