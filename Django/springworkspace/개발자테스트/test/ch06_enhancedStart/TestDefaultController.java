package ch06_enhancedStart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// 부트스트랩 테스트 

public class TestDefaultController {
	// 테스트할 대상  -  이 컨트롤러의 목적은 요청을 처리해 응답해주는 것이다. 
	private DefaultController controller;
	private Request request ;//= new SampleRequest();
	private RequestHandler handler;// = new SampleHandler();
	
	
	/////////////////////// 테스트에 사용할 이너클래스 //////////////////
	private class SampleRequest implements Request{
		private String name;
		public SampleRequest(){
			this.name = "Test";
		}
		public SampleRequest(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		
	}
	
	private class SampleHandler implements RequestHandler{
		public Response process(Request request) throws Exception{
			return new SampleResponse();
		}
	}
	
	// 예외상황을 일부러 만들어 주는 요청 핸들러 
	private class SampleExceptionHandler implements RequestHandler{
		public Response process(Request request) throws Exception{
			 throw new Exception("error processor request !");
		}
	
	}
	
	private class SampleResponse implements Response{
		// 구현 없음 - 리펙토링 전
		// 리펙토링 후 소스코드  아래 부분 전체 
		private static final String NAME = "Test";
		public String getName(){
			return NAME;
		}
		public boolean equals(Object object){
			boolean result = false;
			if(object instanceof SampleResponse){
				result = ((SampleResponse)object).getName().equals(getName());
			}
			return result;
		}
		public int hashCode(){
			return NAME.hashCode();
		}
	}
	////////////////////////////////////////////////////////////////////// 
	
	@Before
	public void initialize() throws Exception{
		controller = new DefaultController();
		request = new SampleRequest();
		handler = new SampleHandler();
		controller.addHandler(request, handler);
	}
	
	@Test (expected= RuntimeException.class)
	public void testMethod(){
		throw new RuntimeException("저를 구현하세요. 구현할게 남았음...");
	}
	

	@Test 
	public void addHandler메소드가잘작동되는지test(){
		//Request request = new SampleRequest();
		//RequestHandler handler = new SampleHandler();
		//controller.addHandler(request, handler);
		RequestHandler handler2 = controller.getHandler(request);
		assertSame("우리가 컨트롤러에 등록한 핸들러와 얻어온 핸들러가 동일한 것인지",handler2,handler);
	}
	
	@Test
	public void 리퀘스트을잘처리하는지test(){
		//Request request = new SampleRequest();
		//RequestHandler handler = new SampleHandler();
		//controller.addHandler(request, handler);
		Response response = controller.processRequest(request);
		// 앞부분의 String으로 실패 원인을 기술한다. 즉 assertNotNull(object)와 같은 시그너츠는 쓰지말자~~ 
		assertNotNull("response로 null이 리턴되면안된다.",response);
		assertEquals("response는 SampleResponse타입이어야 한다.",SampleResponse.class,response.getClass());
	}
	
	@Test
	public void 요청응답으로에러응답하기test(){
		Request request = new SampleRequest("TestError");
		RequestHandler handler = new SampleExceptionHandler();
		controller.addHandler(request, handler);
		Response response = controller.processRequest(request);
		assertNotNull("response로 null이 리턴되면안된다.",response);
		assertEquals("response는 ErrorResponse타입이어야 한다.",ErrorResponse.class,response.getClass());
	}
	
	// 예외를 던지는 메소드 테스트 하기 
	
	@Test(expected=RuntimeException.class)
	public void 핸들러를정의하지않고사용하기test(){
		SampleRequest request = new SampleRequest("TestNotDefined");
		controller.getHandler(request);
	}
	
	@Test(expected=RuntimeException.class)
	public void 중복된리퀘스에예외발생시키는지test(){
		SampleRequest request = new SampleRequest();// 픽쳐에 이미 디폴트name인 Test로 등록된바 있음 
		SampleHandler handler = new SampleHandler();
		// RuntimeException이 발생될 것이다.
		controller.addHandler(request,handler);
	}
	
	// 타임아웃 테스트 하기 
	@Test(timeout=130)
	@Ignore(value="이 테스트를 건너뛰는 이유: 제한된 한계시간을 명백하게 결정하기 전까지는 테스트를 보류한다.")
	public void testProcessMultipleRequestsTimeout(){
		Request request;
		Response response = new SampleResponse();
		RequestHandler handler = new SampleHandler();
		for(int i=0;i<99999;i++){
			request = new SampleRequest(String.valueOf(i));
			controller.addHandler(request, handler);
			response = controller.processRequest(request);
			assertNotNull(response);
			assertNotSame(ErrorResponse.class,response.getClass());
		}
		
	}
}
