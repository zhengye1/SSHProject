package com.vincent.SSHProject.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vincent.SSHProject.model.Department;
import com.vincent.SSHProject.model.User;
import com.vincent.SSHProject.model.Role;
import com.vincent.SSHProject.service.UserService;

public class AppControllerTest {

	@Mock
	UserService userService;

	@Mock
	MessageSource message;

	@Mock
	AppControllerService appControllerService;

	@InjectMocks
	AppController appController;

	@Spy
	List<User> users = new ArrayList<User>();

	@Spy
	ModelMap model;

	@Mock
	BindingResult result;

	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		users = getUsers();
	}

	private List<User> getUsers() {
		// TODO Auto-generated method stub
		User u1 = new User();
		u1.setId(1);
		u1.setFirstName("Admin");
		u1.setLastName("Admin");
		u1.setUsername("admin");
		u1.setEmail("admin@akb.co.jp");
		u1.setDateOfBirth(new LocalDate());
		u1.setPassword("admin");
		Department admin = new Department();
		admin.setId(1);
		admin.setName("Admin");
		admin.setDescription("Admin");
		u1.setDepartment(admin);
		Role adminRole = new Role();
		adminRole.setId(1);
		adminRole.setRoleName("ADMIN");
		Set<Role> roles = new HashSet<>();
		roles.add(adminRole);
		u1.setRoles(roles);

		User u2 = new User();
		u2.setId(1);
		u2.setFirstName("Alice");
		u2.setLastName("Lin");
		u2.setUsername("alice.lin");
		u2.setEmail("alice.lin@akb.co.jp");
		u2.setDateOfBirth(new LocalDate());
		u2.setPassword("Alice0102");
		u2.setDepartment(admin);
		u2.setRoles(roles);

		users.add(u1);
		users.add(u2);
		return users;
	}

	@Test
	public void listUsers(){
		when(userService.findAllUsers()).thenReturn(users);
		when(appControllerService.getPrincipal()).thenReturn("admin");
		Assert.assertEquals(appController.listUsers(model), "userslist");
		Assert.assertEquals(model.get("users"), users);
		Assert.assertEquals(model.get("loggedinuser"), "admin");
		verify(userService, atLeastOnce()).findAllUsers();
	}
}
