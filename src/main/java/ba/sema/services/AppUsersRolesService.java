package ba.sema.services;

import java.util.List;

import ba.sema.models.admin.AppRolesModel;
import ba.sema.models.admin.AppUsersModel;
import ba.sema.models.admin.EditAppUserModel;

public interface AppUsersRolesService
{
	public List<AppUsersModel> getUsers();
	public EditAppUserModel loadUserForEdit(int id);
	public void updateUser(EditAppUserModel model);
	public List<AppRolesModel> getRoles(boolean initializeLazyObjects);
}
