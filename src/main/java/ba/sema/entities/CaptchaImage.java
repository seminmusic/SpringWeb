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
@Table(name = "captcha_images")
public class CaptchaImage
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id", nullable = false, unique = true)
	private Integer imageId;
	
	@Column(name = "imagename", nullable = false)
	private String imageName;
	
	@Column(name = "imageextension", length = 10)
	private String imageExtension;
	
	@Column(nullable = false)
	private Byte[] image;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	private CaptchaGroup group;
	
	
	public Integer getImageId()
	{
		return imageId;
	}
	public void setImageId(Integer imageId)
	{
		this.imageId = imageId;
	}
	
	public String getImageName()
	{
		return imageName;
	}
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}
	
	public String getImageExtension()
	{
		return imageExtension;
	}
	public void setImageExtension(String imageExtension)
	{
		this.imageExtension = imageExtension;
	}
	
	public Byte[] getImage()
	{
		return image;
	}
	public void setImage(Byte[] image)
	{
		this.image = image;
	}
	
	public CaptchaGroup getGroup()
	{
		return group;
	}
	public void setGroup(CaptchaGroup group)
	{
		this.group = group;
	}
}
