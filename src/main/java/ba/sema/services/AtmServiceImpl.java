package ba.sema.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.sema.dao.AtmDAO;
import ba.sema.models.atm.AtmModel;

@Service
@Transactional
public class AtmServiceImpl implements AtmService
{
	@Autowired
	private AtmDAO atmDAO;
	
	@Override
	public List<AtmModel> getAllAtms()
	{
		return 
		atmDAO.getAllAtms()
			  .stream()
			  .map(a -> {
				  AtmModel m = new AtmModel();
				  m.setAtmId(a.getAtmId());
				  m.setAtmName(a.getName());
				  m.setAtmAddress(a.getAddress());
				  m.setAtmLongitude(a.getLongitude());
				  m.setAtmLatitude(a.getLatitude());
				  m.setBankName(a.getBank().getBankName());
				  return m;
			  })
			  .collect(Collectors.toList());
	}
}
