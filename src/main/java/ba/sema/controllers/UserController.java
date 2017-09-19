package ba.sema.controllers;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import ba.sema.services.UserService;


@Controller
@RequestMapping(value = "/users")
//@PreAuthorize("isAuthenticated()")
public class UserController
{
	//@Autowired
	//private UserService userService;
	
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String allUsers(Model model)
	{
		return "User/Index";
	}
}
