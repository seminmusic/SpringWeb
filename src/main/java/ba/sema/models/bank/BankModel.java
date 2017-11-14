package ba.sema.models.bank;


public class BankModel
{
	private Integer bankId;
	private String bankName;
	private Short status;
	private String bin;
	private String uppId;
	private Integer bamcardId;
	private Boolean smsRegCodeEnabled;
	
	
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
}
