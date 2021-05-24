/* 
 * ========================================================================
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
package ch03_mastering;
import java.util.HashMap;
import java.util.Map;
/**
 * Default implementation of the controller.
 * @version $Id: DefaultController.java 553 2010-03-06 12:29:58Z paranoid12 $
 */
public class DefaultController implements Controller {
	// 요청 핸들러를 등록할 자료구조
	private Map<String, RequestHandler> requestHandlers = 
			new HashMap<String, RequestHandler>();
	// 주어진 요청에 적합한 리퀘스트핸들러를 반환하는 getter
	protected RequestHandler getHandler(Request request) {
		// RequestHandler를 등록하지 않고 호출하면 예외를 발생
		if (!this.requestHandlers.containsKey(request.getName())) {
			String message = "Cannot find handler for request name " + "["
					+ request.getName() + "]";
			throw new RuntimeException(message); // 프로그래밍 실수임을 알리는 예외 처리방식
		}
		// RequestHandler 가 등록된경우 
		return this.requestHandlers.get(request.getName());
	}
	
	// 컨트롤러 클래스의 핵심 부분  - 요청 처리
	// 요청을 적절한 핸들러에 전달하고, 그 핸들러의 응답을 반환한다.
	// 만약예외가 발생하면 ErrorResponse 클래스로 감싸서 반환한다.
	public Response processRequest(Request request) {
		Response response;
		try {
			response = getHandler(request).process(request);
		} catch (Exception exception) {
			response = new ErrorResponse(request, exception);
		}
		return response;
	}

	//  핸들러 이름의 등록 여부를 확인하고 
	//  이미 등록된 이름이라면 예외를 던지도록 하였다.
	//  이 코드를 관찰하면 분명 요청객체가 전달은 되는데, 정작 사용되는 것은
	// 이름뿐임을 알 수 있다. 이런 일은 코드 작성 보다 인터페이스를 먼저 정의해서
	// 종종 발생한다. 이런 종류의 오버디자인을 피하는 효과적인 방법 중의 하나로
	// 테스트주도 개발이 있다.
	public void addHandler(Request request, RequestHandler requestHandler) {
		if (this.requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException("A request handler has "
					+ "already been registered for request name " + "["
					+ request.getName() + "]");
		} else {
			this.requestHandlers.put(request.getName(), requestHandler);
		}
	}
}
