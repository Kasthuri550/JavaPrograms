import java.util.ArrayList;
import java.util.List;

public class FactorialNumber {

	public static void main(String[] args) {
		
		System.out.println(factorialNumbers(5));

	}

	public static List<Long> factorialNumbers(long n) {

		List<Long> list=new ArrayList<Long>();
		long fact=1,i=1;
		while(fact<=n)
		{
			list.add(fact);
			fact=fact*(++i);
		}

		return list;
	}

}
