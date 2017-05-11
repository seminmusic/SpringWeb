package ba.sema.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "banks")
public class Bank implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	private int bankId;
	
	@Column(name = "bankname", columnDefinition = "character")
	private String bankName;
	
	@Column
	private int status;
	
	@Column
	private String bin;
	
	@Column(name = "uppid")
	private String uppId;
	
	@Column(name = "bamcardid", nullable = true)
	private Integer bamcardId;
	
	
	public int getBankId()
	{
		return bankId;
	}

	public void setBankId(int bankId)
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

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
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

	public void setBamcardId(int bamcardId)
	{
		this.bamcardId = bamcardId;
	}
}
