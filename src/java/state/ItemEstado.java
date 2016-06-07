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
public interface ItemEstado {
    public String getEstado();
    
    public String emprestar(Item item);
    
    public String devolver(Item item);
}
