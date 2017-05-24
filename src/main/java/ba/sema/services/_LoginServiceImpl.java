package ba.sema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao._LoginKorisnikDAO;
import ba.sema.entities._LoginKorisnik;

@Service
@Transactional
public class _LoginServiceImpl implements _LoginService
{
	@Autowired
    private _LoginKorisnikDAO loginDAO;
	
	@Override
	@Transactional
	public _LoginKorisnik findById(int id)
	{
		return loginDAO.findById(id);
	}

	@Override
	@Transactional
	public _LoginKorisnik findByUsername(String username)
	{
		return loginDAO.findByUsername(username);
	}
}
