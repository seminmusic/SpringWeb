package ba.sema.dao;

import java.util.List;

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
		return (_LoginKorisnik)sessionFactory.getCurrentSession()
											 .createQuery("FROM _LoginKorisnik WHERE username = ?")
											 .setString(0, username)
											 .uniqueResult();
		// Initialize LAZY object:
		// Hibernate.initialize(korisnik.getRoleKorisnika());
		// return korisnik;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<_LoginKorisnik> sviLoginKorisnici()
	{
		List<_LoginKorisnik> lista = (List<_LoginKorisnik>)sessionFactory.getCurrentSession().createQuery("FROM _LoginKorisnik ORDER BY korisnikId").list();
		return lista;
	}
}
