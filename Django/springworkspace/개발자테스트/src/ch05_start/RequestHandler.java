package ch05_start;
// 대부분의 궂은 일을 도맡아 처리해줄 목적으로 설계된 도우미 컴포넌트 
public interface RequestHandler {
	// 객체 request가 어떤 예외를 던질지는 알 수 없다. 그런 이유로 
	// process는 모든 예외를 포괄하는 Exception을 던진다.
	Response process(Request request) throws Exception;
}
