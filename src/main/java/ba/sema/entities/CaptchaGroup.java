package ba.sema.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "captcha_groups")
public class CaptchaGroup
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id", nullable = false, unique = true)
	private Integer groupId;
	
	@Column(name = "groupname", nullable = false)
	private String groupName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	private Set<CaptchaImage> images = new HashSet<CaptchaImage>();
	
	
	public Integer getGroupId()
	{
		return groupId;
	}
	public void setGroupId(Integer groupId)
	{
		this.groupId = groupId;
	}
	
	public String getGroupName()
	{
		return groupName;
	}
	
	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}
	
	public Set<CaptchaImage> getImages()
	{
		return images;
	}
	public void setImages(Set<CaptchaImage> images)
	{
		this.images = images;
	}
}
