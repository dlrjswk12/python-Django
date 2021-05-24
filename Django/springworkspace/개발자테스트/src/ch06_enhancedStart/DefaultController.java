package ch06_enhancedStart;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {
	// 요청 핸들러들을 등록할 자료구조
	private Map requestHandlers = new HashMap();

	protected RequestHandler getHandler(Request request){
		if(!this.requestHandlers.containsKey(request.getName())){
			String message = request.getName()+ " 리퀘스트의 핸들러를 찾을 수 없습니다.";
			throw new RuntimeException(message);
		}
		return (RequestHandler)this.requestHandlers.get(request.getName());
	}
	
	
	@Override
	public Response processRequest(Request request) {
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch (Exception e) {
			response = new ErrorResponse(request,e);
		}
		
		return response;
	}

	@Override
	public void addHandler(Request request, RequestHandler requestHandler) {
		if(this.requestHandlers.containsKey(request.getName())){
			throw new RuntimeException(request.getName()+" 는 이미 등록된 것입니다.");
		}else{
			this.requestHandlers.put(request.getName(), requestHandler);
		}

	}

}
