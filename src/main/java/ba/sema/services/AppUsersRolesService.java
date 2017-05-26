package ba.sema.services;

import java.util.List;

import ba.sema.models.admin.AppRolesModel;
import ba.sema.models.admin.AppUsersModel;

public interface AppUsersRolesService
{
	public List<AppUsersModel> getUsers();
	public List<AppRolesModel> getRoles();
}
