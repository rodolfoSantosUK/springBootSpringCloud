package com.rest.wewbsesrvices.restfulwebservices.resource;

import com.rest.wewbsesrvices.restfulwebservices.dao.UserDaoService;
import com.rest.wewbsesrvices.restfulwebservices.domain.User;
import com.rest.wewbsesrvices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Iterator;
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
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        if (null == user) {
            throw new UserNotFoundException("id informado foi : " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(  @Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
       // Construtor de componente de Uri de servlet
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}") // substituindo esse item da requisição pelo id retornado ao salvar usuário
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build(); // vai criar no header o location
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);
        if (null == user)
            throw new UserNotFoundException("id - " + id);
    }

}
