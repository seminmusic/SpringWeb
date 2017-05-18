package ba.sema.services;

import java.util.List;

import ba.sema.models.bank.BankModel;
import ba.sema.models.bank.NewBankModel;

public interface BankService
{
	public void addBank(NewBankModel model);
	public List<BankModel> getAllBanks();
	public void deleteBank(int bankId);
	public void updateBank(NewBankModel model);
	public NewBankModel getBank(int bankId);
}
