package ch04_mock2_easymock;

public class RunCaculator {

	Calculator cal;

	public void setCal(Calculator cal) {

		this.cal = cal;

	}

	public int doSum(int a, int b) {

		System.out.println("***더하기: " + a + "+" + b + "=" + cal.sum(a, b));

		return cal.sum(a, b);

	}

	// echo string to console

	public void sayHello(String str) {

		cal.echo(str);

	}

}