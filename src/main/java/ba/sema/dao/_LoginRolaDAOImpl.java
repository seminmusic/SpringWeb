package ba.sema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ba.sema.entities._LoginRola;

@Repository
public class _LoginRolaDAOImpl implements _LoginRolaDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public _LoginRola findById(int id)
	{
		return (_LoginRola)sessionFactory.getCurrentSession().get(_LoginRola.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<_LoginRola> sveRole()
	{
		List<_LoginRola> role = (List<_LoginRola>)sessionFactory.getCurrentSession().createQuery("FROM _LoginRola ORDER BY rolaId").list();
		return role;
	}
}
