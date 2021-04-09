package org.academiadecodigo.asycntomatics.byebye.dao;

import org.academiadecodigo.asycntomatics.byebye.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class userDaoImp extends GenericDao<User> implements UserDao {


    public userDaoImp() {
        super(User.class);
    }
}
