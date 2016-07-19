package com.vincent.SSHProject.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vincent.SSHProject.dao.UserDAO;
import com.vincent.SSHProject.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private PasswordEncoder encoder;
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userDAO.save(user);

	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	@Override
	public void updateUser(User user) {
		User entity = userDAO.findById(user.getId());
		if(entity!=null){
			entity.setUsername(user.getUsername());
			if(!user.getPassword().equals(entity.getPassword())){
				entity.setPassword(encoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setRoles(user.getRoles());
			entity.setDateOfBirth(user.getDateOfBirth());
			entity.setDepartment(user.getDepartment());
		}

	}

	@Override
	public void deleteUserByUsername(String username) {
		userDAO.deleteByUsername(username);

	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.findAllUsers();
	}

	@Override
	public boolean isUserUsernameUnique(Integer id, String username) {
		// TODO Auto-generated method stub
		User user = userDAO.findByUsername(username);
		return (user == null || ((id != null) && (user.getId() == id)));
	}

}
