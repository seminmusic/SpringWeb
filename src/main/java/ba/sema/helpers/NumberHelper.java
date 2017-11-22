package ba.sema.helpers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import com.google.common.base.Strings;

public class NumberHelper
{
	public static String bigDecimalToCurrencyString(BigDecimal bigDecimal)
	{
		if (bigDecimal == null)
		{
			return "";
		}
		
		DecimalFormatSymbols bsSymbols = new DecimalFormatSymbols();
		bsSymbols.setDecimalSeparator(',');
		bsSymbols.setGroupingSeparator('.');
		DecimalFormat bsCurrencyFormat = new DecimalFormat("#,###,##0.00", bsSymbols);
		
		return bsCurrencyFormat.format(bigDecimal);
	}
	
	public static BigDecimal currencyStringToBigDecimal(String string)
	{
		if (Strings.isNullOrEmpty(string))
		{
			return null;
		}
		
		DecimalFormatSymbols bsSymbols = new DecimalFormatSymbols();
		bsSymbols.setDecimalSeparator(',');
		bsSymbols.setGroupingSeparator('.');
		DecimalFormat bsCurrencyFormat = new DecimalFormat("#,###,##0.00", bsSymbols);
		
		bsCurrencyFormat.setParseBigDecimal(true);
		try
		{
			return (BigDecimal)bsCurrencyFormat.parse(string);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
