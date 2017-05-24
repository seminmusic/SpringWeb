package ba.sema.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ba.sema.helpers.HibernateExporter;


@Controller
@RequestMapping(value = "/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController
{
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String index()
	{
		HibernateExporter exporter = new HibernateExporter("org.hibernate.dialect.PostgreSQLDialect", "ba.sema.entities");
		exporter.exportToConsole();
		//
		return "Admin/Index";
	}
}
