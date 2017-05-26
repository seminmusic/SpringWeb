package ba.sema.dao;

import java.util.List;

import ba.sema.entities._LoginKorisnik;

public interface _LoginKorisnikDAO
{
	public _LoginKorisnik findById(int id);
	public _LoginKorisnik findByUsername(String username);
	//
	public List<_LoginKorisnik> sviLoginKorisnici();
}
