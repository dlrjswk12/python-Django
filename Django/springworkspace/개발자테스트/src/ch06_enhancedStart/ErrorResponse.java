
package ch06_enhancedStart;

/**
 * Response에 에러가 난경우 리턴 시켜준다.
*/
public class ErrorResponse implements Response {
	private Request originalRequest;
	private Exception originalException;

	public ErrorResponse(Request request, Exception exception) {
		this.originalRequest = request;
		this.originalException = exception;
	}

	public Request getOriginalRequest() {
		return this.originalRequest;
	}

	public Exception getOriginalException() {
		return this.originalException;
	}

	@Override
	public String getName() {
		return "ErrorResponse";
	}
}
