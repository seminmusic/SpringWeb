package ba.sema.models.admin;

import java.util.ArrayList;
import java.util.List;

public class AppUsersModel
{
	private Integer korisnikId;
    private String ime;
    private String prezime;
	private String email;
	private String username;
    private String status;
    private List<String> roleKorisnika = new ArrayList<String>();
    
    
	public Integer getKorisnikId()
	{
		return korisnikId;
	}
	public void setKorisnikId(Integer korisnikId)
	{
		this.korisnikId = korisnikId;
	}
	public String getIme()
	{
		return ime;
	}
	public void setIme(String ime)
	{
		this.ime = ime;
	}
	public String getPrezime()
	{
		return prezime;
	}
	public void setPrezime(String prezime)
	{
		this.prezime = prezime;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public List<String> getRoleKorisnika()
	{
		return roleKorisnika;
	}
	public void setRoleKorisnika(List<String> roleKorisnika)
	{
		this.roleKorisnika = roleKorisnika;
	}
}
