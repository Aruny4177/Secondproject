package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Model.User;

@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveOrUpdateUser(User user) {
		Session session = sessionFactory.openSession();
		try {
			session.saveOrUpdate(user);
			session.flush();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;
	}

	@Override
	public User getUserById(int userId) {

		Session session = sessionFactory.openSession();
		return (User) session.get(User.class, userId);

	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from  UserDetails  ORDER BY userId ASC");
		List<User> users = query.list();
		return users;

	}

	@Override
	public boolean delete(int userId) {

		try {

			User user = getUserById(userId);
			sessionFactory.getCurrentSession().delete(user);
			sessionFactory.getCurrentSession().flush();

			return true;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

}
