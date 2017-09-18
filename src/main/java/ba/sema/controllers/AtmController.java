package ba.sema.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ba.sema.models.atm.AtmModel;
import ba.sema.services.AtmService;
import ba.sema.services.UserService;


@Controller
@RequestMapping(value = "/atms")
//@PreAuthorize("isAuthenticated()")
public class AtmController
{
	@Autowired
	private AtmService atmService;
	
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String allAtms(Model model)
	{
		List<AtmModel> atms = atmService.getAllAtms();
		
		ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        
        ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("bookName", "Java");
        objectNode1.put("price", 100);
        
        ObjectNode objectNode2 = mapper.createObjectNode();
        objectNode2.put("bookName", "Spring");
        objectNode2.put("price", 200);
        
        ObjectNode objectNode3 = mapper.createObjectNode();
        objectNode3.put("bookName", "Liferay");
        objectNode3.put("price", 500);
        
        arrayNode.add(objectNode1);
        arrayNode.add(objectNode2);
        arrayNode.add(objectNode3);
		
		model.addAttribute("atmLocationsArray", arrayNode);
		return "Atm/Index";
	}
}
