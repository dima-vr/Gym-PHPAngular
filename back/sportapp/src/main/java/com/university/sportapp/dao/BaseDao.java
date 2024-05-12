package com.university.sportapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class BaseDao<T> {

    protected JpaRepository<T, Long> repository;

    public BaseDao(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void update(T entity) {
        repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
