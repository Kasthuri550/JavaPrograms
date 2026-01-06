package Basicmaths;

import java.util.ArrayList;

public class CheckPrimeNumberAndRange {

	public static void main(String[] args) {

		int n = 25;
		
		primeNumber(n);
		primeNumberRange(1,10);
	}
	
	private static void primeNumberRange(int start,int end) {
		
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=start;i<=end;i++)
		{
			if(i<2) continue;
			
			int count=0;
			
			for(int j=1;j*j<=i;j++)
			{
				if((i%j)==0)
				{
					count++;
					
					if((i/j)!=j)
						count++;
				}
			}
			
			if(count==2)
				list.add(i);
		}
		
		System.out.println(list);
	}

	private static void primeNumber(int n)
	{
		int count=0;
		
		for(int i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				count++;
				
				if((n/i)!=i)
					count++;
			}
		}
		
		if(count==2)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
	}

}
