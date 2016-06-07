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
public class ItemEstadoDisponivel implements ItemEstado{

    @Override
    public String getEstado() {
        return "Disponivel";
    }

    @Override
    public String emprestar(Item item) {
        item.setEstado(new ItemEstadoEmprestado());
        return item.getNomeEstado();
    }

    @Override
    public String devolver(Item item) {
        return "Impossivel";
    }
    
}
