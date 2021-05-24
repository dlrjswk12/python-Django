package cop.sjw.aop;

public class Sum implements IProc{
	public Long execute(int...args) {
		long sum =0;
		for(long i=args[0];i<=args[1];i++) {
			sum += i;
		}
		return sum;
	}
}