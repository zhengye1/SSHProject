package com.vincent.SSHProject.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AppControllerService {

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    public String getPrincipal(){
        String userName = null;
        Object principal = getCurrentUser();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
    
    public Object getCurrentUser(){
    	return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    

	public boolean isRolePresent(Collection<? extends GrantedAuthority> auth, String role){
    	for (GrantedAuthority grantedAuthority : auth){
    		if (grantedAuthority.getAuthority().equals(role)){
    			return true;
    		}
    	}
    	return false;
    }
}
