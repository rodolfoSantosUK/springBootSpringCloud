package com.rest.wewbsesrvices.restfulwebservices.resource;

import com.rest.wewbsesrvices.restfulwebservices.dao.UserDaoService;
import com.rest.wewbsesrvices.restfulwebservices.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }


}
