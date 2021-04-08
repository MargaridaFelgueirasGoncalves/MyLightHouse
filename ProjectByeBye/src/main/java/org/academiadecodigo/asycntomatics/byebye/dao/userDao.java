package org.academiadecodigo.asycntomatics.byebye.dao;

import org.academiadecodigo.asycntomatics.byebye.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class userDao implements Dao<User>{


    private Class<User> user;


    public userDao(Class<User> user){
        this.user = user;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(user);
        Root<User> root = criteriaQuery.from(user);
        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public User findById(Integer id) {
        return em.find(user, id);
    }

    @Override
    public User saveOrUpdate(User modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(user, id));
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
