package ba.sema.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ba.sema.entities.Bank;
import ba.sema.services.BankService;


@Controller
@RequestMapping(value = "/banks")
public class BankController
{
	private static final Logger logger = Logger.getLogger(BankController.class);
	
	@Autowired
	private BankService bankService;
	
	public BankController()
	{
		logger.info("Kreiran BankController()");
	}
	
	// GET - Sve banke:
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String listAllBanks(Model model)
	{
		List<Bank> allBanks = bankService.getAllBanks();
		model.addAttribute("banks", allBanks);
		return "Bank/Index";
	}
	
	// GET - Nova banka:
	@RequestMapping(value = "/new-bank", method = RequestMethod.GET)
	public ModelAndView newBank(ModelAndView model)
	{
		Bank bank = new Bank();
		model.addObject("bank", bank);
		model.setViewName("Bank/Edit");
		return model;
	}
	
	// GET - Izmjena banke:
	// Sa HttpServletRequest:
//	@RequestMapping(value = "/edit-bank", method = RequestMethod.GET)
//	public ModelAndView editBank(HttpServletRequest request)
//	{
//		int bankId = Integer.parseInt(request.getParameter("bankId"));
//		Bank bank = bankService.getBank(bankId);
//		ModelAndView model = new ModelAndView("Bank/Edit");
//		model.addObject("bank", bank);
//		return model;
//	}
	// Sa @RequestParam:
	// Default - naziv varijable je isti kao naziv parametra u requestu: @RequestParam int nazivVarijable
	// Ako je naziv parametra u requestu različit od naziva kojeg smo dali varijabli: @RequestParam("nazivParametra") int nazivVarijable
	// Neobavezan parametar: @RequestParam(required = false) int nazivVarijable
	// Default vrijednost varijable ako je parametar u requestu prazan ili ga nema nikako: @RequestParam(defaultValue = "18") int nazivVarijable
	// Pristup svim parametrima requesta kao Map objekat (key-value parovi): @RequestParam Map<String, String> parametri
	@RequestMapping(value = "/edit-bank", method = RequestMethod.GET)
	//public ModelAndView editBank(@RequestParam int bankId)
	//public ModelAndView editBank(@RequestParam("bankId") int id)
	//public ModelAndView editBank(@RequestParam("bankId") int id, @RequestParam(value = "nes", required = false) String nesto)
	//public ModelAndView editBank(@RequestParam("bankId") int id, @RequestParam(value = "nes", required = false, defaultValue = "Default vrijednost") String nesto)
	//public ModelAndView editBank(@RequestParam("bankId") int id, @RequestParam(value = "nes", defaultValue = "Default vrijednost") String nesto)  // Kada ima defaultValue, automatski je postavljeno required = false
	public ModelAndView editBank(@RequestParam Map<String, String> sviParametri)  // Svi parametri requesta kao key-value parovi
	{
		//Bank bank = bankService.getBank(bankId);
		//Bank bank = bankService.getBank(id);
		Bank bank = bankService.getBank(Integer.parseInt(sviParametri.get("bankId")));
		
		String nesto = sviParametri.get("nes");
		System.out.println("====== nesto parametar: " + nesto + " =======");
		
		ModelAndView model = new ModelAndView("Bank/Edit");
		model.addObject("bank", bank);
		return model;
	}
	
	// POST - Nova ili izmjena:
	@RequestMapping(value = "/save-bank", method = RequestMethod.POST)
	public ModelAndView saveBank(@Valid @ModelAttribute Bank bank, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
//			ModelAndView model = new ModelAndView("Bank/Edit");
//			model.addObject("bank", bank);
//			return model;
			return new ModelAndView("Bank/Edit");
		}
		
		if (bank.getBankId() == 0)
		{
			// New:
			bankService.addBank(bank);
		}
		else
		{
			// Update:
			bankService.updateBank(bank);
		}
		return new ModelAndView("redirect:/banks/list");
	}
	
	// GET - Brisanje banke:
	@RequestMapping(value = "/delete-bank", method = RequestMethod.GET)
	public ModelAndView deleteBank(HttpServletRequest request)
	{
		int bankId = Integer.parseInt(request.getParameter("bankId"));
		bankService.deleteBank(bankId);
		return new ModelAndView("redirect:/banks/list");
	}
}
