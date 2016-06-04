/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author breno
 */
public interface DAO<T> {
    public List<T> getAll();
    public T get(int id);
    public T get(String id);
    public void insert(T t);
    public void update(T t);
    public void delete(T t);
}
