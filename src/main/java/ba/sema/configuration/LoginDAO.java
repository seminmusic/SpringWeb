package ba.sema.configuration;

import ba.sema.entities._LoginKorisnik;

public interface LoginDAO
{
	_LoginKorisnik findById(int id);
	_LoginKorisnik findByUsername(String username);
}
