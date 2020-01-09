package com.rest.wewbsesrvices.restfulwebservices.dao;

import com.rest.wewbsesrvices.restfulwebservices.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component // Torna-se um bean gerenciado pelo Spring
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    private static Integer usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if ( null == user.getId()   ) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
 
}
