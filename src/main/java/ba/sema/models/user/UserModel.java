package ba.sema.models.user;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class UserModel
{
	private Integer userId;
	private String bankName;
	private String telephoneNumber;
	private Short status;
	private Timestamp activationDate;
	private Timestamp registrationDate;
	private Timestamp registrationCodeExpiration;
	private Timestamp deactivationDate;
	private Short dailyLimitTransactions;
	private BigDecimal dailyLimitAmount;
	private Short loginAttempts;
	
	
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
	public String getBankName()
	{
		return bankName;
	}
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}
	
	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}
	
	public Short getStatus()
	{
		return status;
	}
	public void setStatus(Short status)
	{
		this.status = status;
	}
	
	public Timestamp getActivationDate()
	{
		return activationDate;
	}
	public void setActivationDate(Timestamp activationDate)
	{
		this.activationDate = activationDate;
	}
	
	public Timestamp getRegistrationDate()
	{
		return registrationDate;
	}
	public void setRegistrationDate(Timestamp registrationDate)
	{
		this.registrationDate = registrationDate;
	}
	
	public Timestamp getRegistrationCodeExpiration()
	{
		return registrationCodeExpiration;
	}
	public void setRegistrationCodeExpiration(Timestamp registrationCodeExpiration)
	{
		this.registrationCodeExpiration = registrationCodeExpiration;
	}
	
	public Timestamp getDeactivationDate()
	{
		return deactivationDate;
	}
	public void setDeactivationDate(Timestamp deactivationDate)
	{
		this.deactivationDate = deactivationDate;
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
	
	public Short getLoginAttempts()
	{
		return loginAttempts;
	}
	public void setLoginAttempts(Short loginAttempts)
	{
		this.loginAttempts = loginAttempts;
	}
}
