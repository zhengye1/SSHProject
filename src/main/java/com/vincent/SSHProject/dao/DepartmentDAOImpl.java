package com.vincent.SSHProject.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vincent.SSHProject.model.Department;
import com.vincent.SSHProject.model.User;

@Repository("departmentDAO")
public class DepartmentDAOImpl extends AbstractDao<Integer, Department> implements DepartmentDAO {

	static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);
	
	@Override
	public Department findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public Department findByName(String name) {
		// TODO Auto-generated method stub
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		return (Department) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsers(String name) {
		Department d = findByName(name);
		// TODO Auto-generated method stub
		String hql = "FROM DEPARTMENT D INNER JOIN USER U ON D.DEPID = U.DEPID WHERE D.DEPID = :depid";
		Query q = (Query) getSession().createQuery(hql);
		q.setParameter("depId", d.getId());
		return (List<User>)q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAllDepartments() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Department> departments = (List<Department>) criteria.list();
		return departments;
	}

}
