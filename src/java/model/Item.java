    package model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import state.ItemEstado;
import state.ItemEstadoDisponivel;

/**
 *
 * @author anubis
 */
public class Item extends Observable{
    private int id;
    private String titulo;
    private List<Observer> observers;
    ItemEstado estado;

    public Item(){}
    
    public Item(int id, String titulo, String estado) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        this.id = id;
        this.titulo = titulo;
        String classeEstado = "state.ItemEstado" + estado;
        this.estado = (ItemEstado) Class.forName(classeEstado).getConstructor().newInstance();
        this.observers = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ItemEstado getEstado() {
        return estado;
    }

    public void setEstado(ItemEstado estado) {
        this.estado = estado;
        if(this.estado instanceof ItemEstadoDisponivel){
            setChanged();
            notifyObservers();
        }
    }
    
    public String getNomeEstado() {
        return estado.getEstado();
    }
    
    
}
