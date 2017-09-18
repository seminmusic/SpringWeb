package ba.sema.models.atm;

import java.math.BigDecimal;

public class AtmModel
{
	private Integer atmId;
	private String atmName;
	private String atmAddress;
	private BigDecimal atmLongitude;
	private BigDecimal atmLatitude;	
	private String bankName;
	
	
	public Integer getAtmId()
	{
		return atmId;
	}
	public void setAtmId(Integer atmId)
	{
		this.atmId = atmId;
	}
	
	public String getAtmName()
	{
		return atmName;
	}
	public void setAtmName(String atmName)
	{
		this.atmName = atmName;
	}
	
	public String getAtmAddress()
	{
		return atmAddress;
	}
	public void setAtmAddress(String atmAddress)
	{
		this.atmAddress = atmAddress;
	}
	
	public BigDecimal getAtmLongitude()
	{
		return atmLongitude;
	}
	public void setAtmLongitude(BigDecimal atmLongitude)
	{
		this.atmLongitude = atmLongitude;
	}
	
	public BigDecimal getAtmLatitude()
	{
		return atmLatitude;
	}
	public void setAtmLatitude(BigDecimal atmLatitude)
	{
		this.atmLatitude = atmLatitude;
	}
	
	public String getBankName()
	{
		return bankName;
	}
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}
}
