package ba.sema.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;


@Entity
@Table(name = "banks")
@DynamicInsert(true)
public class Bank
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id", nullable = false, unique = true)
	private Integer bankId;
	
	@Column(name = "bankname", nullable = false, length = 100)
	private String bankName;
	
	@Column(nullable = false)
	private Short status;
	
	@Column(nullable = false, unique = true, length = 10)
	private String bin;
	
	@Column(name = "uppid", length = 10)
	private String uppId;
	
	@Column(name = "bamcardid")
	private Integer bamcardId;
	
	@Column(name = "smsregcode", nullable = false)
	private Boolean smsRegCodeEnabled;
	
	@Column(name = "smsdelayhours", nullable = false)
	private Short smsDelayHours;
	
	@Column(name = "regcodevalidityhours", nullable = false)
	private Short regCodeValidityHours;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "primaryKey.bank")
	private Set<BankUser> banksUsers = new HashSet<BankUser>();
	
	
	public Integer getBankId()
	{
		return bankId;
	}
	public void setBankId(Integer bankId)
	{
		this.bankId = bankId;
	}

	public String getBankName()
	{
		return bankName;
	}
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public Short getStatus()
	{
		return status;
	}
	public void setStatus(Short status)
	{
		this.status = status;
	}

	public String getBin()
	{
		return bin;
	}
	public void setBin(String bin)
	{
		this.bin = bin;
	}

	public String getUppId()
	{
		return uppId;
	}
	public void setUppId(String uppId)
	{
		this.uppId = uppId;
	}

	public Integer getBamcardId()
	{
		return bamcardId;
	}
	public void setBamcardId(Integer bamcardId)
	{
		this.bamcardId = bamcardId;
	}
	
	public Boolean getSmsRegCodeEnabled()
	{
		return smsRegCodeEnabled;
	}
	public void setSmsRegCodeEnabled(Boolean smsRegCodeEnabled)
	{
		this.smsRegCodeEnabled = smsRegCodeEnabled;
	}
	
	public Short getSmsDelayHours()
	{
		return smsDelayHours;
	}
	public void setSmsDelayHours(Short smsDelayHours)
	{
		this.smsDelayHours = smsDelayHours;
	}
	
	public Short getRegCodeValidityHours()
	{
		return regCodeValidityHours;
	}
	public void setRegCodeValidityHours(Short regCodeValidityHours)
	{
		this.regCodeValidityHours = regCodeValidityHours;
	}
	
	public Set<BankUser> getBanksUsers()
	{
		return banksUsers;
	}
	public void setBanksUsers(Set<BankUser> banksUsers)
	{
		this.banksUsers = banksUsers;
	}
}
