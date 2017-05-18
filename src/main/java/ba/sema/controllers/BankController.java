package ba.sema.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ba.sema.models.bank.BankModel;
import ba.sema.models.bank.NewBankModel;
import ba.sema.services.BankService;


@Controller
@RequestMapping(value = "/banks")
public class BankController
{
	@Autowired
	private BankService bankService;	
	
	// GET - Sve banke:
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String listAllBanks(Model model)
	{
		List<BankModel> allBanks = bankService.getAllBanks();
		model.addAttribute("bankModels", allBanks);
		return "Bank/Index";
	}
	
	// GET - Nova banka:
	@RequestMapping(value = "/new-bank", method = RequestMethod.GET)
	public ModelAndView newBank(ModelAndView model)
	{
		NewBankModel bank = new NewBankModel();
		model.addObject("newBankModel", bank);
		model.setViewName("Bank/Edit");
		return model;
	}
	
	// GET - Izmjena banke:
	@RequestMapping(value = "/edit-bank", method = RequestMethod.GET)
	public ModelAndView editBank(@RequestParam Map<String, String> sviParametri)
	{
		NewBankModel bank = bankService.getBank(Integer.parseInt(sviParametri.get("bankId")));
		ModelAndView model = new ModelAndView("Bank/Edit");
		model.addObject("newBankModel", bank);
		return model;
	}
	
	// POST - Novi ili izmjena:
	@RequestMapping(value = "/save-bank", method = RequestMethod.POST)
	public ModelAndView saveBank(@Valid @ModelAttribute("newBankModel") NewBankModel bank, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			return new ModelAndView("Bank/Edit");
		}
		
		if (bank.getBankId() == null)
		{
			// Novi:
			bankService.addBank(bank);
		}
		else
		{
			// Izmjena:
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
