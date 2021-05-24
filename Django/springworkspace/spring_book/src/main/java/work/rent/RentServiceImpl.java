package work.rent;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("rentService")
public class RentServiceImpl implements RentService{
	@Resource(name = "rentDAO")
	private RentDAO rentDAO;

	public void createRent(Map<String, String> rent){
		rentDAO.createRent(rent);
	}

	public void updateConfirmRent(Map<String, String> rentParam){
		rentDAO.updateConfirmRent(rentParam);
	}
	public void deleteReturn(Map<String, String> rentParam){
		rentDAO.deleteReturn(rentParam);
	}

	public void updateExtend(Map<String, String> rentParam){
		rentDAO.updateExtend(rentParam);
	}
}
