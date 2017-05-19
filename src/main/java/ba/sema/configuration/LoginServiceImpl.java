package ba.sema.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.entities._LoginKorisnik;

@Service
@Transactional
public class LoginServiceImpl implements LoginService
{
	@Autowired
    private LoginDAO loginDAO;
	
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
