package com.vincent.SSHProject.service;

import java.util.List;

import com.vincent.SSHProject.model.Department;
import com.vincent.SSHProject.model.User;

public interface DepartmentService {
	Department findById(int id);
    
	Department findByDepartmentName(String name);
     
    List<Department> findAll();
    
    List<User> findUsersInDepartment(String name);
}
