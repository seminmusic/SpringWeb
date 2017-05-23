package ba.sema.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "_login_rola")
public class _LoginRola
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rola_id", nullable = false, unique = true)
    private Integer rolaId;
	
    @Column(name = "nazivrole", nullable = false, unique = true, length = 15)
    private String nazivRole;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleKorisnika")
    private Set<_LoginKorisnik> korisniciRole = new HashSet<_LoginKorisnik>();
    
    
	public Integer getRolaId()
	{
		return rolaId;
	}
	public void setRolaId(Integer rolaId)
	{
		this.rolaId = rolaId;
	}

	public String getNazivRole()
	{
		return nazivRole;
	}
	public void setNazivRole(String nazivRole)
	{
		this.nazivRole = nazivRole;
	}
	
	public Set<_LoginKorisnik> getKorisniciRole()
	{
		return korisniciRole;
	}
	public void setKorisniciRole(Set<_LoginKorisnik> korisniciRole)
	{
		this.korisniciRole = korisniciRole;
	}
	
	
	@Override
    public String toString() 
	{
		return "Rola [rolaId=" + rolaId + ", nazivRole=" + nazivRole + "]";
    }
}
