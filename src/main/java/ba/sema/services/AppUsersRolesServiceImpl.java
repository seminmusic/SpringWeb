package ba.sema.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao._LoginKorisnikDAO;
import ba.sema.entities._LoginKorisnik;
import ba.sema.entities._LoginRola;
import ba.sema.models.admin.AppRolesModel;
import ba.sema.models.admin.AppUsersModel;

@Service
@Transactional
public class AppUsersRolesServiceImpl implements AppUsersRolesService
{
	@Autowired
	private _LoginKorisnikDAO loginKorisnikDAO;
	
	@Override
	@Transactional
	public List<AppUsersModel> getUsers()
	{
		List<_LoginKorisnik> korisnici = loginKorisnikDAO.sviLoginKorisnici();
		List<AppUsersModel> modeli = new ArrayList<AppUsersModel>();
		for (_LoginKorisnik korisnik : korisnici)
		{
			AppUsersModel model = new AppUsersModel();
			model.setKorisnikId(korisnik.getKorisnikId());
			model.setIme(korisnik.getIme());
			model.setPrezime(korisnik.getPrezime());
			model.setEmail(korisnik.getEmail());
			model.setUsername(korisnik.getUsername());
			model.setStatus(korisnik.getStatus());
			for (_LoginRola rola : korisnik.getRoleKorisnika())
			{
				model.getRoleKorisnika().add(rola.getNazivRole());
			}
			modeli.add(model);
		}
		return modeli;
	}

	@Override
	@Transactional
	public List<AppRolesModel> getRoles()
	{
		return null;
	}
}
