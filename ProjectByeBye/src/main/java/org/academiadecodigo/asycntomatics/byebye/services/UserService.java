package org.academiadecodigo.asycntomatics.byebye.services;
import org.academiadecodigo.asycntomatics.byebye.model.User;

import java.util.List;

public interface UserService {


        User get(Integer id);

        User save(User user);

        void delete(Integer id);

        List<User> list();


}
