package ba.sema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.sema.helpers.HibernateExporter;
import ba.sema.models.admin.AppUsersRolesModel;
import ba.sema.services.AppUsersRolesService;


@Controller
@RequestMapping(value = "/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController
{
	@Autowired
	private AppUsersRolesService appUsersRolesService;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index()
	{
		return "Admin/Index";
	}
	
	@RequestMapping(value = "/app-users-roles", method = RequestMethod.GET)
	public ModelAndView applicationUsersAndRoles()
	{
		AppUsersRolesModel data = new AppUsersRolesModel();
		data.setUsers(appUsersRolesService.getUsers());
		
		ModelAndView model = new ModelAndView("Admin/ApplicationUsersAndRoles");
		model.addObject("model", data);
		
		return model;
	}
	
	@RequestMapping(value = "/generate-ddl", method = RequestMethod.GET)
	public ModelAndView generateDDL()
	{
		HibernateExporter exporter = new HibernateExporter("org.hibernate.dialect.PostgreSQLDialect", "ba.sema.entities");
		// exporter.exportToConsole();
		String[] createQueries = exporter.getCreateQueries();
		
		ModelAndView model = new ModelAndView("Admin/GenerateDDL");
		model.addObject("createQueries", createQueries);
		
		return model;
	}
}
