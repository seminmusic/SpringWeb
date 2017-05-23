package ba.sema.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
@Table(name = "transactions")
public class Transaction
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id", nullable = false, unique = true)
	private Integer transactionId;
	
	@Column(name = "transactiontype", nullable = false, length = 20)
	private String transactionType;
	
	@Column(nullable = false)
	private Timestamp created;
	
	@Column(nullable = false)
	private BigDecimal amount;
	
	@Column(name = "currentstatus", nullable = false)
	private Short currentStatus;
	
	@Column(length = 12)
	private String stan;
	
	@Column(length = 12)
	private String rrn;
	
	@Column(name = "authcode", length = 6)
	private String authCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id", nullable = false)
	private User sender;
	
	
	public Integer getTransactionId()
	{
		return transactionId;
	}
	public void setTransactionId(Integer transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public String getTransactionType()
	{
		return transactionType;
	}
	public void setTransactionType(String transactionType)
	{
		this.transactionType = transactionType;
	}
	
	public Timestamp getCreated()
	{
		return created;
	}
	public void setCreated(Timestamp created)
	{
		this.created = created;
	}
	
	public BigDecimal getAmount()
	{
		return amount;
	}
	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
	
	public Short getCurrentStatus()
	{
		return currentStatus;
	}
	public void setCurrentStatus(Short currentStatus)
	{
		this.currentStatus = currentStatus;
	}
	
	public String getStan()
	{
		return stan;
	}
	public void setStan(String stan)
	{
		this.stan = stan;
	}
	
	public String getRrn()
	{
		return rrn;
	}
	public void setRrn(String rrn)
	{
		this.rrn = rrn;
	}
	
	public String getAuthCode()
	{
		return authCode;
	}
	public void setAuthCode(String authCode)
	{
		this.authCode = authCode;
	}
	
	public User getSender()
	{
		return sender;
	}
	public void setSender(User sender)
	{
		this.sender = sender;
	}
}
