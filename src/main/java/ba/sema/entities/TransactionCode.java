package ba.sema.entities;

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
@Table(name = "transactions_code")
public class TransactionCode
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code_id", nullable = false, unique = true)
	private Integer codeId;
	
	@Column(nullable = false, length = 15)
	private String code;
	
	@Column(name = "durationhours", nullable = false)
	private Short durationHours;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_id", nullable = false)
	private Transaction transaction;
	
	
	public Integer getCodeId()
	{
		return codeId;
	}
	public void setCodeId(Integer codeId)
	{
		this.codeId = codeId;
	}
	
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	
	public Short getDurationHours()
	{
		return durationHours;
	}
	public void setDurationHours(Short durationHours)
	{
		this.durationHours = durationHours;
	}
	
	public Transaction getTransaction()
	{
		return transaction;
	}
	public void setTransaction(Transaction transaction)
	{
		this.transaction = transaction;
	}
}
