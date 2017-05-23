package ba.sema.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "parameters")
public class Parameter
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parameter_id", nullable = false, unique = true)
	private Integer parameterId;
	
	@Column(name = "parametername", nullable = false)
	private String parameterName;
	
	@Column(name = "parametervalue", nullable = false)
	private String parameterValue;
	
	@Column
	private Boolean active;
	
	
	public Integer getParameterId()
	{
		return parameterId;
	}
	public void setParameterId(Integer parameterId)
	{
		this.parameterId = parameterId;
	}
	
	public String getParameterName()
	{
		return parameterName;
	}
	public void setParameterName(String parameterName)
	{
		this.parameterName = parameterName;
	}
	
	public String getParameterValue()
	{
		return parameterValue;
	}
	public void setParameterValue(String parameterValue)
	{
		this.parameterValue = parameterValue;
	}
	
	public Boolean getActive()
	{
		return active;
	}
	public void setActive(Boolean active)
	{
		this.active = active;
	}
}
