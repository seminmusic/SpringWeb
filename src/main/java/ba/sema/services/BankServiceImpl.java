package ba.sema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao.BankDAO;
import ba.sema.entities.Bank;

@Service
@Transactional
public class BankServiceImpl implements BankService
{
	@Autowired
	private BankDAO bankDAO;
	public void setBankDAO(BankDAO bankDAO)
	{
		this.bankDAO = bankDAO;
	}
	
	@Override
	@Transactional
	public void addBank(Bank bank)
	{
		bankDAO.addBank(bank);
	}

	@Override
	@Transactional
	public List<Bank> getAllBanks()
	{
		return bankDAO.getAllBanks();
	}

	@Override
	@Transactional
	public void deleteBank(int bankId)
	{
		bankDAO.deleteBank(bankId);
	}

	@Override
	public Bank updateBank(Bank bank)
	{
		return bankDAO.updateBank(bank);
	}

	@Override
	public Bank getBank(int bankId)
	{
		return bankDAO.getBank(bankId);
	}
}
