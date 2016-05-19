package com.vincent.SSHProject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincent.SSHProject.model.Role;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findByRoleName(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
