package com.rest.wewbsesrvices.restfulwebservices.resource;

import com.rest.wewbsesrvices.restfulwebservices.dao.UserDaoService;
import com.rest.wewbsesrvices.restfulwebservices.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser (@PathVariable int id) {
        return userDaoService.findOne (id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user ) {
        User savedUser = userDaoService.save(user);

    }


}
