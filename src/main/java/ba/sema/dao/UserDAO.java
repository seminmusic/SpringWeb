package ba.sema.dao;

import java.util.List;

import ba.sema.entities.User;
import ba.sema.models.DataTablesParameters;
import ba.sema.models.user.UserModel;

public interface UserDAO
{
	public void addUser(User user);
	public int countAllUsers();
	public List<UserModel> filteredUsersModels(DataTablesParameters parameters);
}
