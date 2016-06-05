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
public class Reserva {
    
    private String matriculaUsuario;
    private int iditem;
    private int posicao;
    
    public Reserva(){}
    
    public Reserva(String matriculaUsuario, int iditem, int posicao){
        this.matriculaUsuario = matriculaUsuario;
        this.iditem = iditem;
        this.posicao = posicao;
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

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    
}
