package ba.sema.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "atms")
public class Atm
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "atm_id", nullable = false, unique = true)
	private Integer atmId;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(length = 100)
	private String address;
	
	@Column(nullable = false)
	private BigDecimal longitude;
	
	@Column(nullable = false)
	private BigDecimal latitude;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id", nullable = false)
	private Bank bank;
	
	
	public Integer getAtmId()
	{
		return atmId;
	}
	public void setAtmId(Integer atmId)
	{
		this.atmId = atmId;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}

	public BigDecimal getLongitude()
	{
		return longitude;
	}
	public void setLongitude(BigDecimal longitude)
	{
		this.longitude = longitude;
	}

	public BigDecimal getLatitude()
	{
		return latitude;
	}
	public void setLatitude(BigDecimal latitude)
	{
		this.latitude = latitude;
	}

	public Bank getBank()
	{
		return bank;
	}
	public void setBank(Bank bank)
	{
		this.bank = bank;
	}
}
