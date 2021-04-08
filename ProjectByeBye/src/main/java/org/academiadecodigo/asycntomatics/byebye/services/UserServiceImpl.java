package org.academiadecodigo.asycntomatics.byebye.services;

import javassist.NotFoundException;
import org.academiadecodigo.asycntomatics.byebye.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private CustomerDao customerDao;


    public User getUser() {
        return user;
    }

    @Autowired
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User get(Integer id) {
        customerDao.findById(id);
    }

    @Override
    public User save(User user) {
        return customerDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        User user = Optional.ofNullable(customerDao.findById(id));

        customerDao.delete(id);
    }

    @Override
    public List<User> list() {

        return customerDao.findAll();

    }
}
