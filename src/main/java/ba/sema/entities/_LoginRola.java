package ba.sema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ba.sema.enums.TipRole;


@Entity
@Table(name = "_login_rola")
public class _LoginRola
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rola_id")
    private Integer rolaId;
	
    @Column(name = "nazivrole", length = 15, unique = true, nullable = false)
    private String nazivRole = TipRole.STANDARD.getTipRole();
    
    
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
	
	
	@Override
    public String toString() 
	{
		return "Rola [rolaId=" + rolaId + ", nazivRole=" + nazivRole + "]";
    }
}
