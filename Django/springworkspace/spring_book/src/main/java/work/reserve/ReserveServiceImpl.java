package work.reserve;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("reserveService")
public class ReserveServiceImpl implements ReserveService{
	@Resource(name = "reserveDAO")
	private ReserveDAO reserveDAO;

	public void createReserve(Map<String, String> reserve){
		reserveDAO.createReserve(reserve);
	}

	public void deleteReserve(Map<String, String> reserveParam){
		reserveDAO.deleteReserve(reserveParam);
	}

	public ReserveBean retrieveReserve(Map<String, String> reserveParam){
		return reserveDAO.retrieveReserve(reserveParam);
	}
}
