package sn.api.gestionauchanspring.services;

import sn.api.gestionauchanspring.data.entities.Client;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    T getById(Long id);
    T create(T data);
    T update(T data);
    boolean delete(Long id);
}
