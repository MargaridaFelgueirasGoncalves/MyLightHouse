package org.academiadecodigo.asycntomatics.byebye.services;

import javassist.NotFoundException;
import org.academiadecodigo.asycntomatics.byebye.dao.Dao;
import org.academiadecodigo.asycntomatics.byebye.dao.UserDao;
import org.academiadecodigo.asycntomatics.byebye.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserDao getUser() {
        return userDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(Integer id) {
       return userDao.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        Optional<User> user = Optional.ofNullable(userDao.findById(id));

        userDao.delete(id);
    }

    @Override
    public List<User> list() {

        return userDao.findAll();

    }
}
