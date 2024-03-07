import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialOfLargeNumbers {

	public static void main(String[] args) {
		
		int n=1000;
	    ArrayList<Integer> fact=factorial(n);
	    fact.forEach(System.out::print);

	}
	
	public static ArrayList<Integer> factorial(int n)
	{
	    ArrayList<Integer> al=new ArrayList<Integer>();
	    
	    BigInteger fact=BigInteger.valueOf(1);
	    
	    for(int i=1;i<=n;i++)
	    {
	        fact=fact.multiply(BigInteger.valueOf(i));
	    }
	    
	    String s=String.valueOf(fact);
	    
	    for(int i=0;i<s.length();i++)
	    {
	    	int num=Integer.parseInt(String.valueOf(s.charAt(i)));
	    	al.add(num);
	    }
	    
	    return al;
	}

}
