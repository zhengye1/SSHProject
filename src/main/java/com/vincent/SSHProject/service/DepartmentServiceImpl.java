package com.vincent.SSHProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincent.SSHProject.dao.DepartmentDAO;
import com.vincent.SSHProject.model.Department;
import com.vincent.SSHProject.model.User;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDAO dao;
	
	@Override
	public Department findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Department findByDepartmentName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return dao.findAllDepartments();
	}

	@Override
	public List<User> findUsersInDepartment(String name) {
		// TODO Auto-generated method stub
		return dao.findUsers(name);
	}

}
