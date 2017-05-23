package ba.sema.entities;

import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "banks_users")
@AssociationOverrides
(
	{
		@AssociationOverride(name = "primaryKey.bank", joinColumns = @JoinColumn(name = "bank_id")),
		@AssociationOverride(name = "primaryKey.user", joinColumns = @JoinColumn(name = "user_id")) 
	}
)
public class BankUser
{
	@EmbeddedId
	private BankUserId primaryKey = new BankUserId();  // Kompozitni PK
	
	@Transient
	private Bank bank;
	
	@Transient
	private User user;
	
	@Column(name = "dailylimit_transactions")
	private Short dailyLimitTransactions;
	
	@Column(name = "dailylimit_amount")
	private BigDecimal dailyLimitAmount;
	
	
	public BankUserId getPrimaryKey()
	{
		return primaryKey;
	}
	public void setPrimaryKey(BankUserId primaryKey)
	{
		this.primaryKey = primaryKey;
	}
	
	public Bank getBank()
	{
		return getPrimaryKey().getBank();
	}
	public void setBank(Bank bank)
	{
		getPrimaryKey().setBank(bank);
	}
	
	public User getUser()
	{
		return getPrimaryKey().getUser();
	}
	public void setUser(User user)
	{
		getPrimaryKey().setUser(user);
	}
	
	public Short getDailyLimitTransactions()
	{
		return dailyLimitTransactions;
	}
	public void setDailyLimitTransactions(Short dailyLimitTransactions)
	{
		this.dailyLimitTransactions = dailyLimitTransactions;
	}
	
	public BigDecimal getDailyLimitAmount()
	{
		return dailyLimitAmount;
	}
	public void setDailyLimitAmount(BigDecimal dailyLimitAmount)
	{
		this.dailyLimitAmount = dailyLimitAmount;
	}
}
