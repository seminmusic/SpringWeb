package ba.sema.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao.BankDAO;
import ba.sema.entities.Bank;
import ba.sema.models.bank.BankModel;
import ba.sema.models.bank.NewBankModel;

@Service
@Transactional
public class BankServiceImpl implements BankService
{
	@Autowired
	private BankDAO bankDAO;
	
	@Override
	@Transactional
	public void addBank(NewBankModel model)
	{
		Bank bank = new Bank();
		// bank.setBankId(model.getBankId());
		bank.setBankName(model.getBankName());
		bank.setStatus(model.getStatus());
		bank.setBin(model.getBin());
		bank.setUppId(model.getUppId());
		bank.setBamcardId(model.getBamcardId());
		//
		bankDAO.addBank(bank);
	}

	@Override
	@Transactional
	public List<BankModel> getAllBanks()
	{
		List<Bank> banks = bankDAO.getAllBanks();
		List<BankModel> models = new ArrayList<BankModel>();
		for (Bank bank : banks)
		{
			BankModel model = new BankModel();
			model.setBankId(bank.getBankId());
			model.setBankName(bank.getBankName());
			model.setStatus(bank.getStatus());
			model.setBin(bank.getBin());
			model.setUppId(bank.getUppId());
			model.setBamcardId(bank.getBamcardId());
			//
			models.add(model);
		}
		return models;
	}

	@Override
	@Transactional
	public void deleteBank(int bankId)
	{
		bankDAO.deleteBank(bankId);
	}

	@Override
	public void updateBank(NewBankModel model)
	{
		Bank bank = new Bank();
		bank.setBankId(model.getBankId());
		bank.setBankName(model.getBankName());
		bank.setStatus(model.getStatus());
		bank.setBin(model.getBin());
		bank.setUppId(model.getUppId());
		bank.setBamcardId(model.getBamcardId());
		//
		bankDAO.updateBank(bank);
	}

	@Override
	public NewBankModel getBank(int bankId)
	{
		Bank bank = bankDAO.getBank(bankId);
		NewBankModel model = new NewBankModel();
		model.setBankId(bank.getBankId());
		model.setBankName(bank.getBankName());
		model.setStatus(bank.getStatus());
		model.setBin(bank.getBin());
		model.setUppId(bank.getUppId());
		model.setBamcardId(bank.getBamcardId());
		return model;
	}
}
