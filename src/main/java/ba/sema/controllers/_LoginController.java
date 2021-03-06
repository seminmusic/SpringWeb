package ba.sema.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/login")
public class _LoginController
{
	@RequestMapping(value = {"", "/", "/prijava"}, method = RequestMethod.GET)
	public String prijava()
	{
		return "_Login/Index";
	}
	
	@RequestMapping(value = "/odjava", method = RequestMethod.POST)
	public String odjava(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {
        	new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        System.out.println("ODJAVA KORISNIKA ...");
        // return "redirect:/login";
        return "redirect:/";
	}
}
