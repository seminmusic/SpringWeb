package ba.sema.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ba.sema.enums.StatusKorisnika;


@Entity
@Table(name = "_login_korisnik")
public class _LoginKorisnik
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "korisnik_id")
    private Integer korisnikId;
	
	@Column(nullable = false, unique = true)
    private String username;
	
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String ime;
    
    @Column(nullable = false)
    private String prezime;
    
    @Column
    private String email;
    
    @Column(nullable = false)
    private String status = StatusKorisnika.AKTIVAN.getStatus();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    (
    	name = "_login_korisnik_rola", 
    	joinColumns = { @JoinColumn(name = "id_korisnika") }, 
    	inverseJoinColumns = { @JoinColumn(name = "id_role") }
    )
    private Set<_LoginRola> roleKorisnika = new HashSet<_LoginRola>();
    
    
	public Integer getKorisnikId()
	{
		return korisnikId;
	}
	public void setKorisnikId(Integer korisnikId)
	{
		this.korisnikId = korisnikId;
	}

	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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

	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public Set<_LoginRola> getRoleKorisnika()
	{
		return roleKorisnika;
	}
	public void setRoleKorisnika(Set<_LoginRola> roleKorisnika)
	{
		this.roleKorisnika = roleKorisnika;
	}
	
	
	@Override
    public String toString() 
	{
        return "Korisnik [korisnikId=" + korisnikId + ", username=" + username + ", password=" + password
                      + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", status=" + status 
                      + ", roleKorisnika=" + roleKorisnika +"]";
	}
}
