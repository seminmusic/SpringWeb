package ba.sema.models.admin;

import java.util.ArrayList;
import java.util.List;

public class AppRolesModel
{
	private Integer rolaId;
    private String nazivRole;
    private List<String> korisniciRole = new ArrayList<String>();
    
    
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
	public List<String> getKorisniciRole()
	{
		return korisniciRole;
	}
	public void setKorisniciRole(List<String> korisniciRole)
	{
		this.korisniciRole = korisniciRole;
	}
}
