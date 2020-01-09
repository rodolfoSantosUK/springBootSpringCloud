package com.rest.wewbsesrvices.restfulwebservices.resource;

import com.rest.wewbsesrvices.restfulwebservices.dao.UserDaoService;
import com.rest.wewbsesrvices.restfulwebservices.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity createUser(@RequestBody User user ) {
        User savedUser = userDaoService.save(user);

        // Construtor de componente de Uri de servlet
       URI location = ServletUriComponentsBuilder
                      .fromCurrentRequest()
                      .path("/{id}") // substituindo esse item da requisição pelo id retornado ao salvar usuário
                      .buildAndExpand(savedUser.getId()).toUri();

       return  ResponseEntity.created(location).build(); // vai criar no heade o location
    }


}
