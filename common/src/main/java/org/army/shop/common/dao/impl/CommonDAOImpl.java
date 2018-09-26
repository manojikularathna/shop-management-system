package org.army.shop.common.dao.impl;

import org.army.shop.common.dao.CommonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CommonDAOImpl implements CommonDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public <T> T add(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public <T> List<T> get(Class<T> type) {
        return entityManager.createQuery(entityManager.getCriteriaBuilder().createQuery(type)).getResultList();
    }
}