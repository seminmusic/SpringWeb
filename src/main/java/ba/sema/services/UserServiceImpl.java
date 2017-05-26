package ba.sema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao.UserDAO;
import ba.sema.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void addUser(User user)
	{
		userDAO.addUser(user);
	}
}
