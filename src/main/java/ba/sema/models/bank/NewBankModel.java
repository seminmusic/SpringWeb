package ba.sema.models.bank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class NewBankModel
{
	private Integer bankId;
	
	// @NotNull(message = "Obavezan unos naziva banke")  // Ovaj ne provjerava prazne stringove
	// @NotEmpty(message = "Obavezan unos naziva banke")  // Validno i kad su samo spaceovi
	@NotBlank(message = "Naziv banke ne može biti prazan")  // Not null and the trimmed length is greater than 0
	@Size(max = 100, message = "Naziv banke može imati najviše {max} karaktera")
	private String bankName;
	
	// Za int tipove treba koristiti @NotNull, a @NotEmpty se koristi kod string, collection, map ili array. 
	@NotNull(message = "Status je obavezan")
	private Short status;
	
	@NotBlank(message = "BIN ne može biti prazan")
	@Size(max = 10, message = "BIN može imati najviše {max} karaktera")
	private String bin;
	
	@Size(max = 10, message = "UPP ID može imati najviše {max} karaktera")
	private String uppId;
	
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
}
