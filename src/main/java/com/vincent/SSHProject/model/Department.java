package com.vincent.SSHProject.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5186335588393807810L;

	@Id @Column(name="DEPID") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="NAME", unique=true, nullable=false)
	private String name;

	@Column(name="DESCRIPTION")
	private String description;

	@OneToMany(mappedBy="department")
	private List<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String toString(){
		return "Department [id=" + id + ", name=" + name + ", description=" + description +"]\n" + 
				"List of Employee in this department" + users.stream().map(User::getUsername).collect(Collectors.toList());
	}

}
