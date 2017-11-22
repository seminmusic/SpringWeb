package ba.sema.helpers;

import java.text.SimpleDateFormat;

public class DateTimeHelper
{
	private static final SimpleDateFormat bsFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	public static String convertToString(java.sql.Timestamp timestamp) 
	{
		if (timestamp == null)
		{
			return "";
		}
		return bsFormatter.format(timestamp);
	}
}
