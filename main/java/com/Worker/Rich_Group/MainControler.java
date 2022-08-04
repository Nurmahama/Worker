package com.Worker.Rich_Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class MainControler {

    @Autowired
    service service;

    @GetMapping(value = "/findAll")
    public List<User> FindAll () {
      List<User> users = service.findAll();
        return users;  }

    @GetMapping (value = "/findById{id}")
    public User findById (@PathVariable Long id){
        User user = service.findById(id);
        return  user;

    }
    @PostMapping (value = "/create")
    public void create (User user) {
        service.create(user);
    }

  @PutMapping (value  = "/update")
    public void update (@PathVariable Long id,@RequestBody User user) {
        service.update(id,user);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void Delete (@PathVariable Long id) {
        service.delete(id);
    }


}
