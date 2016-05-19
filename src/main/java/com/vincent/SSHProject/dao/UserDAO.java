package com.vincent.SSHProject.dao;

import java.util.List;

import com.vincent.SSHProject.model.User;

public interface UserDAO {
    User findById(int id);
    
    User findByUsername(String username);
     
    void save(User user);
     
    void deleteByUsername(String username);
     
    List<User> findAllUsers();
}
