package ba.sema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ba.sema.entities._LoginKorisnik;

@Repository
public class _LoginKorisnikDAOImpl implements _LoginKorisnikDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public _LoginKorisnik findById(int id)
	{
		return (_LoginKorisnik)sessionFactory.getCurrentSession().get(_LoginKorisnik.class, id);
	}
	
	@Override
	public _LoginKorisnik findByUsername(String username)
	{
		// Generiše 2 query za korisnika i njegove role:
		//return (_LoginKorisnik)sessionFactory.getCurrentSession()
		//									 .createQuery("FROM _LoginKorisnik WHERE username = ?")
		//									 .setString(0, username)
		//									 .uniqueResult();
		
		// Generiše 1 query ukupno:
		Query query = sessionFactory.getCurrentSession()
									.createQuery("SELECT K FROM _LoginKorisnik K " + 
												 "FULL JOIN FETCH K.roleKorisnika RK " + 
												 "WHERE K.username = ?");
		
		return (_LoginKorisnik)query.setString(0, username).uniqueResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<_LoginKorisnik> sviLoginKorisnici()
	{
		//List<_LoginKorisnik> lista = (List<_LoginKorisnik>)sessionFactory.getCurrentSession().createQuery("FROM _LoginKorisnik ORDER BY korisnikId").list();
		//return lista;
		
		System.out.println("================== KORISNICI sa Rolama: ==================");
		Query query = sessionFactory.getCurrentSession()
									.createQuery("SELECT DISTINCT K FROM _LoginKorisnik K " + 
												 "LEFT JOIN FETCH K.roleKorisnika RK " + 
												 "ORDER BY K.korisnikId");
		
		return (List<_LoginKorisnik>)query.list();
	}
	
	@Override
	public void updateUser(_LoginKorisnik korisnik)
	{
		sessionFactory.getCurrentSession().update(korisnik);
	}
}
