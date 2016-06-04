    package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author anubis
 */
public abstract class Item extends Observable{
    private int id;
    private String titulo;
    private List<Observer> observers;

    public Item(){}
    
    public Item(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
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

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
    
    
}
