package ba.sema.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao._LoginKorisnikDAO;
import ba.sema.dao._LoginRolaDAO;
import ba.sema.entities._LoginKorisnik;
import ba.sema.entities._LoginRola;
import ba.sema.models.admin.AppRolesModel;
import ba.sema.models.admin.AppUsersModel;
import ba.sema.models.admin.EditAppUserModel;

@Service
@Transactional
public class AppUsersRolesServiceImpl implements AppUsersRolesService
{
	@Autowired
	private _LoginKorisnikDAO loginKorisnikDAO;
	@Autowired
	private _LoginRolaDAO loginRolaDAO;
	
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
	public EditAppUserModel loadUserForEdit(int id)
	{
		_LoginKorisnik korisnik = loginKorisnikDAO.findById(id);
		
		EditAppUserModel model = new EditAppUserModel();
		model.setKorisnikId(id);
		model.setIme(korisnik.getIme());
		model.setPrezime(korisnik.getPrezime());
		model.setEmail(korisnik.getEmail());
		model.setUsername(korisnik.getUsername());
		model.setStatus(korisnik.getStatus());
		
		korisnik.getRoleKorisnika().forEach((_LoginRola rola) -> {
			model.getRole().add(rola.getRolaId());
		});
		
		List<_LoginRola> sveRole = loginRolaDAO.sveRole();
		sveRole.forEach((_LoginRola rola) -> {
			model.getRoleLista().put(rola.getRolaId(), rola.getNazivRole());
		});
		
		return model;
	}
	
	@Override
	@Transactional
	public void updateUser(EditAppUserModel model)
	{
		_LoginKorisnik korisnik = loginKorisnikDAO.findById(model.getKorisnikId());
		korisnik.setIme(model.getIme());
		korisnik.setPrezime(model.getPrezime());
		korisnik.setEmail(model.getEmail());
		korisnik.setUsername(model.getUsername());
		korisnik.setStatus(model.getStatus());
		
		korisnik.getRoleKorisnika().clear();
		model.getRole().forEach((Integer idRole) -> {
			_LoginRola rola = loginRolaDAO.findById(idRole);
			korisnik.getRoleKorisnika().add(rola);
		});
		
		loginKorisnikDAO.updateUser(korisnik);
	}

	@Override
	@Transactional
	public List<AppRolesModel> getRoles()
	{
		List<_LoginRola> role = loginRolaDAO.sveRole();
		
		List<AppRolesModel> modeli = new ArrayList<AppRolesModel>();
		role.forEach((_LoginRola r) -> {
			AppRolesModel m = new AppRolesModel();
			m.setRolaId(r.getRolaId());
			m.setNazivRole(r.getNazivRole());
			// U rolama su korisnici role LAZY i nisu dostupni dok se ne inicijalizuju.
			// Da bi se inicijalizovali LAZY treba im pristupiti ili pozvati Hibernate.initialize(...) a to se može uraditi
			// samo ako je hibernate sesija još aktivna. Sa @Transactional se označava metod koji će držati sesiju aktivnom
			// dok se metod ne završi pa je najbolje @Transactional postaviti u @Service layer a ne u @Repository layer.
			// Znači, ne moramo u @Repository layeru inicijalizovati LAZY nego može ovdje jer je metod @Transactional i sesija
			// je aktivna, tako da će sa getKorisniciRole() set LAZY korisnika biti popunjen iz baze:
			m.setKorisniciRole(r.getKorisniciRole()
								.stream()
								.map(korisnik -> korisnik.getUsername())
								.collect(Collectors.toList()));
			modeli.add(m);
		});
		return modeli;
	}
}
