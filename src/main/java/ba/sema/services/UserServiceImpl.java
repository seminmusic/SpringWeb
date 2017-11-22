package ba.sema.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao.UserDAO;
import ba.sema.entities.User;
import ba.sema.helpers.DateTimeHelper;
import ba.sema.helpers.NumberHelper;
import ba.sema.models.DataTablesModel;
import ba.sema.models.DataTablesParameters;
import ba.sema.models.user.UserModel;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void addUser(User user)
	{
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public DataTablesModel getUsersData(DataTablesParameters parameters)
	{
		DataTablesModel model = new DataTablesModel();
		
		int ukupanBrojRecorda = userDAO.countAllUsers();
		
		List<UserModel> filtriraniRecordi = userDAO.filteredUsersModels(parameters);
		
		List<UserModel> paginacijaRecordi = filtriraniRecordi.stream()
															 .skip(parameters.getiDisplayStart())
															 .limit(parameters.getiDisplayLength())
															 .collect(Collectors.toList());
		
		List<String[]> data = paginacijaRecordi.stream().map(u -> new String[] 
		{
			u.getUserId().toString(),
			u.getBankName(),
			u.getTelephoneNumber(),
			u.getStatus().toString(),
			DateTimeHelper.convertToString(u.getActivationDate()),
			DateTimeHelper.convertToString(u.getRegistrationDate()),
			DateTimeHelper.convertToString(u.getRegistrationCodeExpiration()),
			DateTimeHelper.convertToString(u.getDeactivationDate()),
			u.getDailyLimitTransactions().toString(),
			NumberHelper.bigDecimalToCurrencyString(u.getDailyLimitAmount()),
			u.getLoginAttempts().toString()
		})
		.collect(Collectors.toList());
		
		model.setsEcho(parameters.getsEcho());
		model.setiTotalRecords(ukupanBrojRecorda);
		model.setiTotalDisplayRecords(filtriraniRecordi.size());
		model.setAaData(data);
		
		return model;
	}
}
