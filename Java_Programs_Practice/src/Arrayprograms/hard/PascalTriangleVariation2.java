package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleVariation2 {

	public static void main(String[] args) {
		
		int n = 5;
		
		pascalTriangleBrute(n);
		pascalTriangleOptimal(n);

	}

	private static void pascalTriangleOptimal(int n) {
		
		long result=1;
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		
		for(int i=1;i<n;i++)
		{
			result*=(n-i);
			result/=i;
			list.add((int) result);
		}
		System.out.println(list);
		
	}

	private static void pascalTriangleBrute(int n) {
		
		List<Integer> list=new ArrayList<>();
		
		for(int i=1;i<=n;i++)
		{
			list.add((int)nCr(n-1,i-1));
		}
		
		System.out.println(list);
	}

	private static long nCr(int n, int r) {
		
		long result=1;
		
		for(int i=0;i<r;i++)
		{
			result*=(n-i);
			result/=(i+1);
		}
		
		return result;		
	}
}
