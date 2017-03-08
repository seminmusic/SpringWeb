package ba.sema.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/list")
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
	@RequestMapping(value = "/edit-bank", method = RequestMethod.GET)
	public ModelAndView editBank(HttpServletRequest request)
	{
		int bankId = Integer.parseInt(request.getParameter("bankId"));
		Bank bank = bankService.getBank(bankId);
		ModelAndView model = new ModelAndView("Bank/Edit");
		model.addObject("bank", bank);
		return model;
	}
	
	// POST - Nova ili izmjena:
	@RequestMapping(value = "/save-bank", method = RequestMethod.POST)
	public ModelAndView saveBank(@ModelAttribute Bank bank)
	{
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
