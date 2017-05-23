package ba.sema.entities;

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

import org.hibernate.annotations.DynamicInsert;


@Entity
@Table(name = "transactions_log")
@DynamicInsert(true)
public class TransactionLog
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id", nullable = false, unique = true)
	private Integer logId;
	
	@Column(name = "logtimestamp", nullable = false)
	private Timestamp logTimestamp;
	
	@Column(name = "newstatus", nullable = false)
	private Short newStatus;
	
	@Column
	private String description;
	
	@Column
	private String initiator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_id", nullable = false)
	private Transaction transaction;
	
	
	public Integer getLogId()
	{
		return logId;
	}
	public void setLogId(Integer logId)
	{
		this.logId = logId;
	}
	
	public Timestamp getLogTimestamp()
	{
		return logTimestamp;
	}
	public void setLogTimestamp(Timestamp logTimestamp)
	{
		this.logTimestamp = logTimestamp;
	}
	
	public Short getNewStatus()
	{
		return newStatus;
	}
	public void setNewStatus(Short newStatus)
	{
		this.newStatus = newStatus;
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getInitiator()
	{
		return initiator;
	}
	public void setInitiator(String initiator)
	{
		this.initiator = initiator;
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
