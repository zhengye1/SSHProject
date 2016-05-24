package com.vincent.SSHProject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vincent.SSHProject.model.User;

@Repository("userDAO")
public class UserDAOImpl extends AbstractDao<Integer, User> implements UserDAO{

	static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	@Override
	public User findById(int id) {
		User user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
		logger.info("findByUsername - Username : {}", username);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User)crit.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@Override
	public void save(User user) {
		persist(user);
	}

	@Override
	public void deleteByUsername(String username) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User)crit.uniqueResult();
		delete(user);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<User> users = (List<User>) criteria.list();

		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
        for(User user : users){
            Hibernate.initialize(user.getUserProfiles());
        }*/
		return users;
	}

}
