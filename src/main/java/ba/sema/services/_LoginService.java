package ba.sema.services;

import ba.sema.entities._LoginKorisnik;

public interface _LoginService
{
	_LoginKorisnik findById(int id);
	_LoginKorisnik findByUsername(String username);
}
