package com.Worker.Rich_Group;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface service {
    List<User> findAll ();
    User findById(Long id);
    void create (User user);
    void update (Long id,User user);
    void delete (Long id);
}
