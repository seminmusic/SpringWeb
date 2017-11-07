package ba.sema.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ctf_log")
public class CtfLog
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id", nullable = false, unique = true)
	private Integer logId;
	
	@Column(name = "logtimestamp", nullable = false)
	private Timestamp logTimestamp;
	
	@Column(name = "filename", nullable = false, length = 20)
	private String fileName;
	
	@Column
	private String description;
	
	
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
	
	public String getFileName()
	{
		return fileName;
	}
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
}
