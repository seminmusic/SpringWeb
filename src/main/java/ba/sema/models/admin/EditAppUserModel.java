package ba.sema.models.admin;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class EditAppUserModel
{
	private Integer korisnikId;
	@NotBlank(message = "Obavezan unos imena")
	@Size(max = 20, message = "Ime može imati najviše {max} karaktera")
    private String ime;
	@NotBlank(message = "Obavezan unos prezimena")
	@Size(max = 20, message = "Prezime može imati najviše {max} karaktera")
    private String prezime;
	@Size(max = 30, message = "E-mail može imati najviše {max} karaktera")
	private String email;
	@NotBlank(message = "Obavezan unos korisničkog imena")
	@Size(max = 30, message = "Korisničko ime može imati najviše {max} karaktera")
	private String username;
	
	
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
}
