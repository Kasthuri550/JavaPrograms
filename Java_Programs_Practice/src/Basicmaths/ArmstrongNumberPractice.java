package Basicmaths;

public class ArmstrongNumberPractice {

	public static void main(String[] args) {

		int n=154;
		
		System.out.println(armstrongNumber(n));
	}

	private static boolean armstrongNumber(int n) {

		int num=n,sum=0;
		
		int len=String.valueOf(n).length();
		
		while(n>0)
		{
			int rem=n%10;
			sum+=Math.pow(rem,len);
			n=n/10;
		}
		
		return sum==num;
	}

}
