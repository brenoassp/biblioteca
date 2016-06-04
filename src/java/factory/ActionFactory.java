/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import action.Action;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class ActionFactory {
    
    public static Action getAction(String action){
        action = "action."+action;
        try {
            return (Action) Class.forName(action).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
            Logger.getLogger(ActionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;    
    }
}
