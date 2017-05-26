package ba.sema.models.admin;

import java.util.ArrayList;
import java.util.List;

public class AppUsersRolesModel
{
	private List<AppUsersModel> users = new ArrayList<AppUsersModel>();
	private List<AppRolesModel> roles = new ArrayList<AppRolesModel>();
	
	
	public List<AppUsersModel> getUsers()
	{
		return users;
	}
	public void setUsers(List<AppUsersModel> users)
	{
		this.users = users;
	}
	public List<AppRolesModel> getRoles()
	{
		return roles;
	}
	public void setRoles(List<AppRolesModel> roles)
	{
		this.roles = roles;
	}
}
