package Basicmaths;

import java.util.ArrayList;

public class PrimeNumberRange {

	public static void main(String[] args) {
		
		int start=1,end=11;
		
		approach1(start,end);
		approach2(start,end);

	}

	private static void approach2(int start, int end) {
		
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=start;i<=end;i++)
		{
			int count=0;
			for(int j=1;j*j<=i;j++)
			{
				if(i%j==0)
				{
					count++;
				
					if(j!=i/j)
					count++;
				}
			}
			
			if(count==2)
				list.add(i);
		}
		
		System.out.println(list);
	}

	private static void approach1(int start, int end) {
		
		
		for(int i=start;i<=end;i++)
		{
			if(isPrime(i))
			{
				System.out.println(i);
			}
		}
	}

	private static boolean isPrime(int n) {
		
		if(n<=1)
			return false;
		
		else if(n==2)
			return true;
		
		else if(n%2==0)
			return false;
		
		for(int i=3;i<=n/2;i+=2)
		{
			if(n%i==0)
				return false;
			
		}
		return true;
	}

}
