package com.vincent.SSHProject.service;

import java.util.List;

import com.vincent.SSHProject.model.Role;

public interface RoleService {

    Role findById(int id);
 
    Role findByRoleName(String roleName);
     
    List<Role> findAll();
}
