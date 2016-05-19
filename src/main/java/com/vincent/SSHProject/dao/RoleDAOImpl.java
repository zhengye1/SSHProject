package com.vincent.SSHProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vincent.SSHProject.model.Role;

@Repository("roleDAO")
public class RoleDAOImpl  extends AbstractDao<Integer, Role>implements RoleDAO{

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findByRoleName(String rolename) {
		// TODO Auto-generated method stub
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("roleName", rolename));
        return (Role) crit.uniqueResult();
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

}
