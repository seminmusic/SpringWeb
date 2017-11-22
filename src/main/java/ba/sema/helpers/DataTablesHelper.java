package ba.sema.helpers;

import java.math.BigDecimal;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;

import ba.sema.models.DataTablesParameters;
import ba.sema.models.user.UserModel;

public class DataTablesHelper
{
	public static String getFilterQuery(DataTablesParameters parameters, Class<?> clazz)
	{
		if (clazz.equals(UserModel.class))
		{
			if (!Strings.isNullOrEmpty(parameters.getsSearch_0()))
			{
				int user_id = Ints.tryParse(parameters.getsSearch_0());
				return " WHERE U.user_id = " + user_id;
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_1()))
			{
				return " WHERE B.bankname = '" + parameters.getsSearch_1() + "'";
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_2()))
			{
				return " WHERE U.telephonenumber = '" + parameters.getsSearch_2() + "'";
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_3()))
			{
				int status = Ints.tryParse(parameters.getsSearch_3());
				return " WHERE U.status = " + status;
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_4()))
			{
				return " WHERE U.activationdate\\:\\:DATE = '" + parameters.getsSearch_4() + "'";
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_5()))
			{
				return " WHERE U.registrationdate\\:\\:DATE = '" + parameters.getsSearch_5() + "'";
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_6()))
			{
				return " WHERE U.registrationcodeexpiration\\:\\:DATE = '" + parameters.getsSearch_6() + "'";
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_7()))
			{
				return " WHERE U.deactivationdate\\:\\:DATE = '" + parameters.getsSearch_7() + "'";
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_8()))
			{
				int transactions = Ints.tryParse(parameters.getsSearch_8());
				return " WHERE BU.dailylimit_transactions = " + transactions;
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_9()))
			{
				BigDecimal amount = NumberHelper.currencyStringToBigDecimal(parameters.getsSearch_9());
				return " WHERE BU.dailylimit_amount = " + amount;
			}
			else if (!Strings.isNullOrEmpty(parameters.getsSearch_10()))
			{
				int attempts = Ints.tryParse(parameters.getsSearch_10());
				return " WHERE U.loginattempts = " + attempts;
			}
			else
			{
				return "";
			}
		}
		return "";
	}
	
	public static String getSortQuery(DataTablesParameters parameters, Class<?> clazz)
	{
		int sortKolonaInt = Ints.tryParse(parameters.getiSortCol_0());
		String sortSmjer = parameters.getsSortDir_0().toUpperCase();
		if (clazz.equals(UserModel.class))
		{
			switch (sortKolonaInt)
			{
				case 0:
					return " ORDER BY U.user_id " + sortSmjer;
				case 1:
					return " ORDER BY B.bankname " + sortSmjer;
				case 2:
					return " ORDER BY U.telephonenumber " + sortSmjer;
				case 3:
					return " ORDER BY U.status " + sortSmjer;
				case 4:
					return " ORDER BY U.activationdate " + sortSmjer;
				case 5:
					return " ORDER BY U.registrationdate " + sortSmjer;
				case 6:
					return " ORDER BY U.registrationcodeexpiration " + sortSmjer;
				case 7:
					return " ORDER BY U.deactivationdate " + sortSmjer;
				case 8:
					return " ORDER BY BU.dailylimit_transactions " + sortSmjer;
				case 9:
					return " ORDER BY BU.dailylimit_amount " + sortSmjer;
				case 10:
					return " ORDER BY U.loginattempts " + sortSmjer;
				default:
					return " ORDER BY U.user_id ";
			}
		}
		return "";
	}
}
