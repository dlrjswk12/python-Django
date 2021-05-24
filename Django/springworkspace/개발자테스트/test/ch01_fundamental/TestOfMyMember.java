package ch01_fundamental;


//import org.junit.Assert;

import static org.junit.Assert.*;

import org.junit.Test;

import ch01_fundamental.MyMember;

public class TestOfMyMember {
	@Test
	public void 같은필드값으로만들어지는객체를동일객체로보는가(){
		MyMember a = new MyMember(); a.setId("sjw");a.setName("성주원");
		MyMember b = new MyMember(); b.setId("sjw");b.setName("성주원");
		// 와 상당히 많게 assertEquals() 메소드가 오버로딩 되어 있네요.
		// 그 중 하나입니다.
		
		
		
	 // 	Assert.assertEquals("같은객체",a,b);    import 구간 참고
		assertEquals("같은객체 무엇을 넣어도 상관없습니다.",a,b); // import에서 static Assert.* 를 하면 앞애 Assert 가 없어도 된다.
		
	}
}
