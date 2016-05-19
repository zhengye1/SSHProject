package com.vincent.SSHProject.model;

import java.io.Serializable;

public enum RoleType implements Serializable{
	MEMBER("MEMBER"),
	LEADER("LEADER"),
	ADMIN("ADMIN");
	
	String roleType;
	private RoleType(String roleType){
		this.roleType = roleType;
	}
	
	public String getRoleType(){
		return this.roleType;
	}
	
}
