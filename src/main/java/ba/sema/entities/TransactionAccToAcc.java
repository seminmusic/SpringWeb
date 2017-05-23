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
@Table(name = "transactions_acctoacc")
public class TransactionAccToAcc
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acctoacc_id", nullable = false, unique = true)
	private Integer accToAccId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transaction_id", nullable = false)
	private Transaction transaction;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipient_id", nullable = false)
	private User recipient;
	
	
	public Integer getAccToAccId()
	{
		return accToAccId;
	}
	public void setAccToAccId(Integer accToAccId)
	{
		this.accToAccId = accToAccId;
	}
	
	public Transaction getTransaction()
	{
		return transaction;
	}
	public void setTransaction(Transaction transaction)
	{
		this.transaction = transaction;
	}
	
	public User getRecipient()
	{
		return recipient;
	}
	public void setRecipient(User recipient)
	{
		this.recipient = recipient;
	}
}
