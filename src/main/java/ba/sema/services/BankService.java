package ba.sema.services;

import java.util.List;

import ba.sema.entities.Bank;

public interface BankService
{
	public void addBank(Bank bank);
	public List<Bank> getAllBanks();
	public void deleteBank(int bankId);
	public Bank updateBank(Bank bank);
	public Bank getBank(int bankId);
}
