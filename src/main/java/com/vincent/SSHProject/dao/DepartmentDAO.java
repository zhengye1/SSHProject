package com.vincent.SSHProject.dao;

import java.util.List;

import com.vincent.SSHProject.model.Department;
import com.vincent.SSHProject.model.User;

public interface DepartmentDAO {
	Department findById(int id);
	Department findByName(String name);
	List<User> findUsers(String name);
	List<Department> findAllDepartments();
}
