package ba.sema.dao;

import ba.sema.entities._LoginKorisnik;

public interface _LoginKorisnikDAO
{
	_LoginKorisnik findById(int id);
	_LoginKorisnik findByUsername(String username);
}
