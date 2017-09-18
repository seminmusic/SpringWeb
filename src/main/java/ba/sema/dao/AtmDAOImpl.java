package ba.sema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ba.sema.entities.Atm;

@Repository
public class AtmDAOImpl implements AtmDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Atm> getAllAtms()
	{
		return sessionFactory.getCurrentSession().createQuery("SELECT A FROM Atm A " +
															  "LEFT JOIN FETCH A.bank B " +
															  "ORDER BY A.atmId").list();
	}
}
