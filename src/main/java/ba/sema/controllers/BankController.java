package ba.sema.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ba.sema.models.bank.BankModel;
import ba.sema.models.bank.NewBankModel;
import ba.sema.services.BankService;


@Controller
@RequestMapping(value = "/banks")
@PreAuthorize("isAuthenticated()")
public class BankController
{
	@Autowired
	private BankService bankService;	
	
	// GET - Sve banke:
	@RequestMapping(value = {"", "/", "/list"}, method = RequestMethod.GET)
	public String listAllBanks(Model model, @ModelAttribute("delete-error") String deleteErrorMessage)
	{
		List<BankModel> allBanks = bankService.getAllBanks();
		model.addAttribute("bankModels", allBanks);
		model.addAttribute("deleteErrorMessage", deleteErrorMessage);
		return "Bank/Index";
	}
	
	// GET - Nova banka:
	@RequestMapping(value = "/new-bank", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'UNOS')")
	public ModelAndView newBank(ModelAndView model)
	{
		NewBankModel bank = new NewBankModel();
		model.addObject("newBankModel", bank);
		model.setViewName("Bank/Edit");
		return model;
	}
	
	// GET - Izmjena banke:
	@RequestMapping(value = "/edit-bank/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'UNOS')")
	public ModelAndView editBank(@PathVariable("id") int bankId)
	{
		NewBankModel bank = bankService.getBank(bankId);
		ModelAndView model = new ModelAndView("Bank/Edit");
		model.addObject("newBankModel", bank);
		return model;
	}
	
	// POST - Novi ili izmjena:
	@RequestMapping(value = "/save-bank", method = RequestMethod.POST)
	@PreAuthorize("hasAnyAuthority('ADMIN', 'UNOS')")
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
	@PreAuthorize("hasAuthority('ADMIN')")
	public ModelAndView deleteBank(HttpServletRequest request, RedirectAttributes redirectAttributes)
	{
		int bankId = Integer.parseInt(request.getParameter("bankId"));
		try
		{
			bankService.deleteBank(bankId);
		}
		catch (Exception e)
		{
			redirectAttributes.addFlashAttribute("delete-error", "Error while trying delete bank from database!");
		}
		return new ModelAndView("redirect:/banks/list");
	}
}
