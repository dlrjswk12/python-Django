package ch06_enhancedStart;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
//
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.matchers.JUnitMatchers.hasItem;
//
public class TestWithHamcrest {
	private List<String> values;
	@Before
	public void setupList(){
		values = new ArrayList<String>();
		values.add("갑");values.add("을");values.add("병");
	}
	@Test
	public void testWithoutHamcrest(){
		assertTrue(values.contains("자") || values.contains("축") || values.contains("인"));
	}
	
	@Test
	public void testWithHamcrest(){
		assertThat(values,hasItem(anyOf(equalTo("자"),equalTo("축"),equalTo("인"))));
	}
	/*
	 * 널리 쓰이는 Hamcrest 매쳐 
	 * 
	 * anthing  - 무엇이든 상관없이 모든 것을 가리킴, assert 문의 가독성을 높이고 싶을 때 유용하다.
	 * is  - 문장 가독성 향상 목적으로만 사용된다.
	 * allOf - 포함한 모든 매처가 매칭되는지 검사한다( && 연산자와 동일). 
	 * anyOf - 포함한 매처 중 어느 하나라도 매치되는 것이 있는지 검사한다. (|| 연산자와 동일) 
	 * not - 포함한 매처들의 의미를 부정한다(자바의 ! 연산자와 동일) 
	 * instanceOf, isCompatibleType  - 객체들이 호환 가능한 타입인지 확인한다. 
	 * sameInstance - 객체 신원을 확인한다.
	 * notNullValue,nullValue - 값이 null인지 혹은 null이 아닌지 검사한다.
	 * hasProperty - 자바빈이 특정 속성을 갖는지 검사한다. 
	 * hasEntry, hasKey, hasValue - 주어진 Map이 명시된 entry, key, value를 포함하는지 검사한다. 
	 * hasItem, hasItems - 주어진 컬렉션이 명시한 아이템, 혹은 아이템들을 포함하는지 검사한다.
	 * closeTo, greaterThan, greaterThanOrEqual, lessThan, lessThanOrEqual - 주어진 숫자가 또 다른 숫자에 근접
	 * 한지, 더 큰지, 더 크거나 같은지, 더 작은지, 더 작거나 같은지 검사한다.
	 * equalToIgnoreCase - 주어진 문자열이 다른 문자열과 일치하는지 검사한다(대소문자 무시) 
	 * equalToIgnoringWhiteSpace - 주어진 문자열이 다른 문자열과 일치하는지 검사한다(공백문자 무시) 
	 * containsString, endsWith,startWith - 주어진 문자열이 다른 문자열을 포함하는지, 그 문자열로 시작하거나 끝나는지 검사한다.
	 */
}
