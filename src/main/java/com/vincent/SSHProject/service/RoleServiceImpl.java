package com.vincent.SSHProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincent.SSHProject.dao.RoleDAO;
import com.vincent.SSHProject.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleDAO dao;
	
	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return dao.findByRoleName(roleName);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
