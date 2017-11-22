package ba.sema.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ba.sema.models.DataTablesModel;
import ba.sema.models.DataTablesParameters;
import ba.sema.services.UserService;


@Controller
@RequestMapping(value = "/users")
//@PreAuthorize("isAuthenticated()")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String allUsers(Model model)
	{
		return "User/Index";
	}
	
	@RequestMapping(value = "/ajax/users-data", method = RequestMethod.GET)
	@ResponseBody
	public Object usersData(DataTablesParameters parameters)
	{
		try
		{
			DataTablesModel model = userService.getUsersData(parameters);
			return ResponseEntity.status(HttpStatus.OK).body(model);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
