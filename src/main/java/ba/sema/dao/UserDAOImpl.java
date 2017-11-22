package ba.sema.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ba.sema.entities.User;
import ba.sema.helpers.DataTablesHelper;
import ba.sema.models.DataTablesParameters;
import ba.sema.models.user.UserModel;

@Repository
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public int countAllUsers()
	{
		Number number = (Number)sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM User").uniqueResult();
		return number.intValue();
	}
	
	@Override
	public List<UserModel> filteredUsersModels(DataTablesParameters parameters)
	{
		String filter = DataTablesHelper.getFilterQuery(parameters, UserModel.class);
		String sort = DataTablesHelper.getSortQuery(parameters, UserModel.class);
		String sql = " SELECT  U.user_id AS userId, " +
					 " 		   B.bankname AS bankName, " +
					 "         U.telephonenumber AS telephoneNumber, " +
					 "         U.status AS status, " +
					 "         U.activationdate AS activationDate, " +
					 "         U.registrationdate AS registrationDate, " +
					 "         U.registrationcodeexpiration AS registrationCodeExpiration, " +
					 "         U.deactivationdate AS deactivationDate, " +
					 "         BU.dailylimit_transactions AS dailyLimitTransactions, " +
					 "         BU.dailylimit_amount AS dailyLimitAmount, " +
					 "         U.loginattempts AS loginAttempts " +
					 " FROM users U " +
					 " LEFT JOIN banks_users BU ON BU.user_id = U.user_id " + 
					 " LEFT JOIN banks B ON B.bank_id = BU.bank_id " +
					   filter +
					   sort;
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql)
														.addScalar("userId")
														.addScalar("bankName")
														.addScalar("telephoneNumber")
														.addScalar("status")
														.addScalar("activationDate")
														.addScalar("registrationDate")
														.addScalar("registrationCodeExpiration")
														.addScalar("deactivationDate")
														.addScalar("dailyLimitTransactions")
														.addScalar("dailyLimitAmount")
														.addScalar("loginAttempts");
		
		@SuppressWarnings("unchecked")
		List<UserModel> resultList = (List<UserModel>)query.setResultTransformer(Transformers.aliasToBean(UserModel.class)).list();
		
		return resultList;
	}
}
