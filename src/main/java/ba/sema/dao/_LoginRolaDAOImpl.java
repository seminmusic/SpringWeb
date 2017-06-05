package ba.sema.dao;

import java.util.List;

import org.hibernate.Query;
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
		//List<_LoginRola> role = (List<_LoginRola>)sessionFactory.getCurrentSession().createQuery("FROM _LoginRola ORDER BY rolaId").list();
		//return role;
		
		System.out.println("================== ROLE sa Korisnicima: ==================");
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT DISTINCT R FROM _LoginRola R " + 
							 "LEFT JOIN FETCH R.korisniciRole KR " +
							 "LEFT JOIN FETCH KR.roleKorisnika RK " +
							 "ORDER BY R.rolaId");
		
		return (List<_LoginRola>)query.list();
	}
}
