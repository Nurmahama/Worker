package com.Worker.Rich_Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceClas implements service {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {

        User user = null;
        try {
            user = userRepository.findById(id).get();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void create(User user) {

        userRepository.save(user);
    }

    @Override
    public void update(Long id, User user) {

        User olduser = findById(id);
        olduser.setName(user.getName());
        olduser.setSurname(user.getSurname());
        olduser.setDay_of_birth(user.getDay_of_birth());
        olduser.setJob_title(user.getJob_title());
        olduser.setSalary(user.getSalary());
        olduser.setStart_date_work(user.getStart_date_work());
        olduser.setInformation(user.getInformation());
        userRepository.save(olduser);
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }
    }
