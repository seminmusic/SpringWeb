package ba.sema.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ba.sema.helpers.HibernateExporter;
import ba.sema.models.admin.AppUsersModel;
import ba.sema.models.admin.AppUsersRolesModel;
import ba.sema.models.admin.EditAppUserModel;
import ba.sema.services.AppUsersRolesService;


@Controller
@RequestMapping(value = "/admin")
// @PreAuthorize("hasAuthority('ADMIN')")
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
	
	@RequestMapping(value = "/app-users-roles/ajax/edit-user", method = RequestMethod.GET)
	public Object editUser(@RequestParam("userId") int id)
	{
		boolean imaGreska = false;
		
		if (imaGreska)
		{
			// return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Greška na serveru.");  // Ne postavlja UTF-8
			
			HttpHeaders responseHeaders = new HttpHeaders();
			
			// HTML format responsa:
			// responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			// return new ResponseEntity<String>("<div style='color:red'>Desila se greška.</div>", responseHeaders, HttpStatus.BAD_REQUEST);
			
			// Text format responsa:
			responseHeaders.add("Content-Type", "text/plain; charset=utf-8");
			return new ResponseEntity<String>("Desila se greška.", responseHeaders, HttpStatus.BAD_REQUEST);
		}
		else
		{
			EditAppUserModel user = appUsersRolesService.loadUserForEdit(id);
			
			ModelAndView model = new ModelAndView("Admin/_EditUser");
			model.addObject("user", user);
			
			return model;
		}
	}
	
	@RequestMapping(value = "/app-users-roles/ajax/update-user", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateUser(@Valid @ModelAttribute("user") EditAppUserModel user, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			
		}
		
		appUsersRolesService.updateUser(user);
		
		ModelAndView model = new ModelAndView("Admin/_AppUsers");
		model.addObject("users", appUsersRolesService.getUsers());
		
		return model;
	}
	
	@RequestMapping(value = "/app-users-roles/ajax/cancel-update-user", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView cancelUpdateUser()
	{
		ModelAndView model = new ModelAndView("Admin/_AppUsers");
		model.addObject("users", appUsersRolesService.getUsers());
		
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
