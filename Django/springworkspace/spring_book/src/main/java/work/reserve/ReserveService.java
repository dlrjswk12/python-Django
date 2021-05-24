package work.reserve;

import java.util.Map;


public interface ReserveService {
	public ReserveBean retrieveReserve(Map<String, String> reserveParam);
	public void createReserve(Map<String, String> reserve);
	public void deleteReserve(Map<String, String> reserveParam);


}
