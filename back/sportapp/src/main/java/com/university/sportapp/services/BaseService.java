package com.university.sportapp.services;
import com.university.sportapp.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public abstract class BaseService<T> {
    protected BaseDao<T> baseDao;

    @Autowired
    public BaseService(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    public T create(T entity) {
        return baseDao.create(entity);
    }

    public List<T> getAll() {
        return baseDao.getAll();
    }

    public T get(Long id) {
        return baseDao.get(id);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public void delete(Long id) {
        baseDao.delete(id);
    }
}

