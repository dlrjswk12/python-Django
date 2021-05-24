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

/**
 * A controller interface.
 * 
 * @version $Id: Controller.java 553 2010-03-06 12:29:58Z paranoid12 $
 */
public interface Controller
{
	// 요청을 받으면, 컨트롤러는 이를 적절한 RequestHandler에게 전달한다.
	// processRequest는 아무런 예외도 선언하지 않았음을 주목
	// 이 메서드는 제어 스택의 마지막에 해당하므로, 
	// 실행 과정 중 발생하는 모든 예외를 잡아 스스로 처리해야 한다.
	// 혹 제대로 대응하지 못하고 던져진 예외는 자바 가상 머신이나 서블릿 컨테이너
	// 까지 도달 할 수 있다. 
	// 이렇게 되면 사용자는 자바가상머신이나 컨테이너가 뿌리는 딱딱하고 난해한
	// 메세지와 마주할 것이다. 직접 대응 코드를 작성해 넣는 쪽이 백 번 낫다.
    Response processRequest( Request request );//요청을 처리할 최상위 메서드
   
    // 자바소스 수정 없이 향후 손쉽게 기능을 확장할 수 있는 길을 터준다.
    // 제어구조 역전용(IOC)
    void addHandler( Request request, RequestHandler requestHandler );
}
