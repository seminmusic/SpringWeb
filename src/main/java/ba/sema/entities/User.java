package ba.sema.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;


@Entity
@Table(name = "users")
@DynamicInsert(true)
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "applicationid", length = 50)
	private String applicationId;
	
	@Column(name = "telephonenumber", length = 15, nullable = false)
	private String telephoneNumber;
	
	@Column(name = "activationdate")
	private Timestamp activationDate;
	
	@Column(name = "registrationdate")
	private Timestamp registrationDate;
	
	@Column(name = "deactivationdate")
	private Timestamp deactivationDate;
	
	//@Column(nullable = false, columnDefinition = "smallint not null default 0")
	@Column(nullable = false)
	private Short status;
	
	@Column(name = "pinhash")
	private String pinHash;
	
	@Column(name = "notificationstoken")
	private String notificationsToken;
	
	//@Column(name = "loginattempts", nullable = false, columnDefinition = "smallint not null default 0")
	@Column(name = "loginattempts", nullable = false)
	private Short loginAttempts;
	
	@Column(name = "registrationcode", length = 20, nullable = false)
	private String registrationCode;
	
	@Column(name = "registrationcodeexpiration", nullable = false)
	private Timestamp registrationCodeExpiration;
	
	
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getApplicationId()
	{
		return applicationId;
	}
	public void setApplicationId(String applicationId)
	{
		this.applicationId = applicationId;
	}

	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	public Timestamp getActivationDate()
	{
		return activationDate;
	}
	public void setActivationDate(Timestamp activationDate)
	{
		this.activationDate = activationDate;
	}

	public Timestamp getRegistrationDate()
	{
		return registrationDate;
	}
	public void setRegistrationDate(Timestamp registrationDate)
	{
		this.registrationDate = registrationDate;
	}

	public Timestamp getDeactivationDate()
	{
		return deactivationDate;
	}
	public void setDeactivationDate(Timestamp deactivationDate)
	{
		this.deactivationDate = deactivationDate;
	}

	public Short getStatus()
	{
		return status;
	}
	public void setStatus(Short status)
	{
		this.status = status;
	}

	public String getPinHash()
	{
		return pinHash;
	}
	public void setPinHash(String pinHash)
	{
		this.pinHash = pinHash;
	}

	public String getNotificationsToken()
	{
		return notificationsToken;
	}
	public void setNotificationsToken(String notificationsToken)
	{
		this.notificationsToken = notificationsToken;
	}

	public Short getLoginAttempts()
	{
		return loginAttempts;
	}
	public void setLoginAttempts(Short loginAttempts)
	{
		this.loginAttempts = loginAttempts;
	}

	public String getRegistrationCode()
	{
		return registrationCode;
	}
	public void setRegistrationCode(String registrationCode)
	{
		this.registrationCode = registrationCode;
	}

	public Timestamp getRegistrationCodeExpiration()
	{
		return registrationCodeExpiration;
	}
	public void setRegistrationCodeExpiration(Timestamp registrationCodeExpiration)
	{
		this.registrationCodeExpiration = registrationCodeExpiration;
	}
}
