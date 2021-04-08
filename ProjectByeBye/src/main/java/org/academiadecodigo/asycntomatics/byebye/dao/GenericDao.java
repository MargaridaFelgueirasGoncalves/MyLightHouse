package org.academiadecodigo.asycntomatics.byebye.dao;

import org.academiadecodigo.asycntomatics.byebye.model.Model;
import org.academiadecodigo.asycntomatics.byebye.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDao<T extends Model> implements Dao<T>{

    protected Class<T> modeltype;


    public GenericDao(Class<T> modeltype) {
        this.modeltype = modeltype;
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modeltype);
        Root<T> root = criteriaQuery.from(modeltype);
        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public T findById(Integer id) {
        return em.find(modeltype, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modeltype, id));
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
