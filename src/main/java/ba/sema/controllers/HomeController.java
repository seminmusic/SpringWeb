package ba.sema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ba.sema.helpers.HibernateExporter;


@Controller
@RequestMapping(value = "/")
public class HomeController
{
	@RequestMapping(value = "/")
	public String index()
	{
		HibernateExporter exporter = new HibernateExporter("org.hibernate.dialect.PostgreSQLDialect", "ba.sema.entities");
		exporter.exportToConsole();
		//
		return "Home/Index";
	}
}
