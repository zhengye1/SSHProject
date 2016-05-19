package com.vincent.SSHProject.dao;

import java.util.List;

import com.vincent.SSHProject.model.Role;

public interface RoleDAO {

    List<Role> findAll();
     
    Role findByRoleName(String rolename);
     
    Role findById(int id);
}
