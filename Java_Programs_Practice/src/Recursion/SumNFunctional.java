package Recursion;

public class SumNFunctional {

	public static void main(String[] args) {
		
		System.out.println(sumFirstN(5L));
		
	}
	
	static long sumFirstN(long n) {

	       if(n==0)
	        {
	            return 0;
	        }

	        return n+sumFirstN(n-1);
	    }

}
