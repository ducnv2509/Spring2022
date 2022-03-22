package DAO;

import java.util.List;

abstract class DAOM<E, K> {
    abstract public void insert(E entity);

    abstract public void update(E entity);

    abstract public void delete(K key);

    abstract public List<E> findAll();

    abstract public E findByID(K key);
}
