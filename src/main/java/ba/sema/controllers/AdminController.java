package ba.sema.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ba.sema.helpers.HibernateExporter;


@Controller
@RequestMapping(value = "/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController
{
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index()
	{
		return "Admin/Index";
	}
	
	@RequestMapping(value = "/app-users-roles", method = RequestMethod.GET)
	public ModelAndView applicationUsersAndRoles()
	{
		ModelAndView model = new ModelAndView("Admin/ApplicationUsersAndRoles");
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
