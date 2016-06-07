/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import model.Item;

/**
 *
 * @author breno
 */
public class ItemEstadoEmprestado implements ItemEstado{

    @Override
    public String getEstado() {
        return "Emprestado";
    }

    @Override
    public String emprestar(Item item) {
        return "Impossivel";
    }

    @Override
    public String devolver(Item item) {
        item.setEstado(new ItemEstadoDisponivel());
        return item.getNomeEstado();
    }
    
}
