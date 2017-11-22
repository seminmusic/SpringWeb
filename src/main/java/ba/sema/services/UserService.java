package ba.sema.services;

import ba.sema.entities.User;
import ba.sema.models.DataTablesModel;
import ba.sema.models.DataTablesParameters;

public interface UserService
{
	public void addUser(User user);
	public DataTablesModel getUsersData(DataTablesParameters parameters);
}
