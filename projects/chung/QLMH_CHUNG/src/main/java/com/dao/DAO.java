package com.dao;

import java.util.List;

public interface DAO<T>{
    List<T> listAll();
    void create(T t);
    T findByID(int id);
    void update(T t);
    void delete(T t);
}
