package ba.sema.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ba.sema.entities.User;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
}
