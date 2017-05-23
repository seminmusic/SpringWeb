package ba.sema.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@SuppressWarnings("serial")
@Embeddable
public class BankUserId implements Serializable
{
	@ManyToOne
	private Bank bank;
	
	@ManyToOne
    private User user;
	
	
	public Bank getBank()
	{
		return bank;
	}
	public void setBank(Bank bank)
	{
		this.bank = bank;
	}

	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
}
