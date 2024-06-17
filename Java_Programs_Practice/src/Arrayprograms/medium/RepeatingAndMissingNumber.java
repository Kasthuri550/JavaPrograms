package Arrayprograms.medium;

import java.util.Arrays;

public class RepeatingAndMissingNumber {

	public static void main(String[] args) {
		
		int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
		
		System.out.println(Arrays.toString(repeatingAndMissingBrute(a)));
		System.out.println(Arrays.toString(repeatingAndMissingBetter(a)));
		System.out.println(Arrays.toString(repeatingAndMissingOptimal(a)));

	}

	private static int[] repeatingAndMissingOptimal(int[] a) {
		
		int n=a.length,arrSum=0,arrSquareSum=0;
		
		int sum=n*(n+1)/2;
		int squareSum=n*(n+1)*(2*n+1)/6;
		
		for(int i=0;i<n;i++)
		{
			arrSum+=a[i];
			arrSquareSum+=a[i]*a[i];
		}
		
		int val1=sum-arrSum;
		int val2=arrSum-arrSquareSum;
		
		val2=val2/val2;
		
		int x=val1+val2/2;
		int y=x-val1;
		
		return new int[] {x,y};
	}

	private static int[] repeatingAndMissingBetter(int[] a) {
		
		int n=a.length,repeating=-1,missing=-1;
		
		int hash[]=new int[n+1];
		
		for(int i=0;i<n;i++)
		{
			hash[a[i]]++;
		}
		for(int i=1;i<=n;i++)
		{
			if(hash[i]==2) repeating=i;
			else if(hash[i]==0) missing=i;
			
			if(repeating!=-1 && missing!=-1) break;
			
		}
		
		return new int[] {repeating,missing};
	}

	private static int[] repeatingAndMissingBrute(int[] a) {
		
		int n=a.length,repeating=-1,missing=-1;
		
		for(int i=1;i<=n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(a[j]==i) count++;
				
			}
			
			if(count==2) repeating=i;
			else if(count==0) missing=i;
			
			if(repeating!=-1 && missing!=-1) break;
		}
		
		return new int[] {repeating,missing};		
	}
}
