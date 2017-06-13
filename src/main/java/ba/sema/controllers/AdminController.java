package ba.sema.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import ba.sema.helpers.HibernateExporter;
import ba.sema.models.JsonResponse;
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
	@Autowired
	private TilesViewResolver viewResolver;
	
	
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
		data.setRoles(appUsersRolesService.getRoles());
		
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
	
//	@RequestMapping(value = "/app-users-roles/ajax/update-user", method = RequestMethod.POST)
//	@ResponseBody
//	public ModelAndView updateUser(@Valid @ModelAttribute("user") EditAppUserModel user, BindingResult bindingResult)
//	{
//		if (bindingResult.hasErrors())
//		{
//			
//		}
//		
//		appUsersRolesService.updateUser(user);
//		
//		ModelAndView model = new ModelAndView("Admin/_AppUsers");
//		model.addObject("users", appUsersRolesService.getUsers());
//		
//		return model;
//	}
	@RequestMapping(value = "/app-users-roles/ajax/update-user", method = RequestMethod.POST)
	@ResponseBody
	public Object updateUser(@Valid @ModelAttribute("user") EditAppUserModel user, BindingResult bindingResult,
							 HttpServletRequest request, HttpServletResponse response)
	{
		JsonResponse jsonResponse = new JsonResponse();
		
		if (bindingResult.hasErrors())
		{
			jsonResponse.setStatus("Podaci nisu validni.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
		}
		
		try
		{
			appUsersRolesService.updateUser(user);
			
			Map<String, Object> modelUsers = new HashMap<String, Object>();
			modelUsers.put("users", appUsersRolesService.getUsers());
			String usersHtml = this.renderViewToString(modelUsers, request, response, "Admin/_AppUsers");
			//
			Map<String, Object> modelRoles = new HashMap<String, Object>();
			modelRoles.put("roles", appUsersRolesService.getRoles());
			String rolesHtml = this.renderViewToString(modelRoles, request, response, "Admin/_AppRoles");
			
			// System.out.println("Users HTML: " + usersHtml);
			// System.out.println("Roles HTML: " + rolesHtml);
			
			jsonResponse.setStatus("Update uspješan.");
			jsonResponse.getData().put("usersHtml", usersHtml);
			jsonResponse.getData().put("rolesHtml", rolesHtml);
			
			return ResponseEntity.status(HttpStatus.OK).body(jsonResponse);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			jsonResponse.setStatus(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(jsonResponse);
		}
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
	
	
	
	private String renderViewToString(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response, final String viewName) 
	{
        final StringWriter html = new StringWriter();
        View view = new View() 
        {
            @Override
            public String getContentType() 
            {
                return "text/html; charset=UTF-8";
            }
            
            @Override
            public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception 
            {
                HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) 
                {
                    @Override
                    public PrintWriter getWriter() throws IOException 
                    {
                        return new PrintWriter(html);
                    }
                };
                View realView = viewResolver.resolveViewName(viewName, Locale.getDefault());
                realView.render(model, request, responseWrapper);
            }
        };
        try 
        {
            view.render(model, request, response);
        } 
        catch (Exception e) 
        {
        	
        }
        return html.toString();
    }
}
