package ch05_start;
// 요청을 처리할 최상위 클래스 
public interface Controller {
	// 아무런 예외 처리를 하지 않았다.
	// 이 메소드는 제어 스택의 마지막에 해당되므로 실행 과정중 발생하는 모든 예외를
	// 스스로 직접 처리해야 하므로 예외를 던지지 않음에 유의하시길.
	Response processRequest(Request request);
	
	// 제어구조역전(IOC)의 예 
	// 아주 중요한 부분 - 향후 자바 소스를 수정하지 않고도 손쉽게 그 기능을 확장할 수 있는 길을 제시 
	void addHandler(Request request,RequestHandler requestHandler);

}
