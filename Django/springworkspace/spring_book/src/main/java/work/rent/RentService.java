package work.rent;

import java.util.Map;


public interface RentService {
	public void createRent(Map<String, String> rent);

	public void updateConfirmRent(Map<String, String> rentParam);
	public void deleteReturn(Map<String, String> rentParam);

	public void updateExtend(Map<String, String> rentParam);

}
