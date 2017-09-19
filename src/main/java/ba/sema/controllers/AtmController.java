package ba.sema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ba.sema.models.atm.AtmModel;
import ba.sema.services.AtmService;


@Controller
@RequestMapping(value = "/atms")
//@PreAuthorize("isAuthenticated()")
public class AtmController
{
	@Autowired
	private AtmService atmService;
	
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String allAtms(Model model) throws JsonProcessingException
	{
		List<AtmModel> atms = atmService.getAllAtms();
		
		ObjectMapper mapper = new ObjectMapper();
    	mapper.enable(SerializationFeature.INDENT_OUTPUT);  // Set pretty printing of json
    	
        String a = mapper.writeValueAsString(atms);
		model.addAttribute("atmLocationsArray", a);
		
		return "Atm/Index";
	}
}
