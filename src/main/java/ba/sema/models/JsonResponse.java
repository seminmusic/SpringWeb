package ba.sema.models;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse
{
	private String status;
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public Map<String, Object> getData()
	{
		return data;
	}
	public void setData(Map<String, Object> data)
	{
		this.data = data;
	}
}
