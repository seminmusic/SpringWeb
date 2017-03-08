package ba.sema.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ba.sema.entities.Bank;

@Repository
public class BankDAOImpl implements BankDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBank(Bank bank)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(bank);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getAllBanks()
	{
		return sessionFactory.getCurrentSession().createQuery("FROM Bank ORDER BY bankId").list();
	}

	@Override
	public void deleteBank(int bankId)
	{
		Bank bank = (Bank)sessionFactory.getCurrentSession().load(Bank.class, bankId);
		if (bank != null)
		{
			sessionFactory.getCurrentSession().delete(bank);
		}
	}

	@Override
	public Bank updateBank(Bank bank)
	{
		sessionFactory.getCurrentSession().update(bank);
		return bank;
	}

	@Override
	public Bank getBank(int bankId)
	{
		return (Bank)sessionFactory.getCurrentSession().get(Bank.class, bankId);
	}
}
