package ba.sema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "banks")
public class Bank
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bank_id")
	private Integer bankId;
	
	@Column(name = "bankname")
	//@NotNull(message = "Obavezan unos naziva banke")  // Ovaj ne provjerava prazne stringove
	//@NotEmpty(message = "Obavezan unos naziva banke")  // Validno i kad su samo spaceovi
	@NotBlank(message = "Naziv banke ne može biti prazan")  // Not null and the trimmed length is greater than 0
	@Size(max = 100, message = "Naziv banke može imati najviše {max} karaktera")
	private String bankName;
	
	@Column
	@NotNull(message = "Status je obavezan")  // @NotEmpty se koristi kod string, collection, map ili array. Za Integer/int treba koristiti @NotNull.
	private Integer status;
	
	@Column
	@NotBlank(message = "BIN ne može biti prazan")
	@Size(max = 10, message = "BIN može imati najviše {max} karaktera")
	private String bin;
	
	@Column(name = "uppid")
	@Size(max = 10, message = "UPP ID može imati najviše {max} karaktera")
	private String uppId;
	
	@Column(name = "bamcardid")
	private Integer bamcardId;
	
	
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

	public Integer getStatus()
	{
		return status;
	}
	public void setStatus(Integer status)
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
}
