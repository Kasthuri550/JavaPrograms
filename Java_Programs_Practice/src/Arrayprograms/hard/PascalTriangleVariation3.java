package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleVariation3 {

	public static void main(String[] args) {
		
		 int n = 5;
		 
//		 pascalTriangleBrute(n);
		 pascalTriangleOptimal(n);

	}

	private static void pascalTriangleOptimal(int n) {
		
		List<List<Integer>> resultList=new ArrayList<>();
				
		for(int i=1;i<=n;i++)
		{
			resultList.add(generateRow(i));
		}
		
		System.out.println(resultList);
		
	}

	private static List<Integer> generateRow(int n) {
		
		int result=1;
		
		List<Integer> tempList=new ArrayList<>();
		tempList.add(1);
		
		for(int i=1;i<n;i++)
		{
			result*=(n-i);
			result/=i;
			tempList.add(result);
		}
		
		return tempList;
	}

	private static void pascalTriangleBrute(int n) {
		
		List<List<Integer>> resultList=new ArrayList<>();
		
		for(int i=1;i<=n;i++)
		{
			List<Integer> tempList=new ArrayList<Integer>();
			for(int j=1;j<=i;j++)
			{
				tempList.add(nCr(i-1,j-1));
			}
			resultList.add(tempList);
		}
		
		System.out.println(resultList);
		
	}

	private static int nCr(int n, int r) {
		
		long result=1;
		
		for(int i=0;i<r;i++)
		{
			result*=(n-i);
			result/=(i+1);
		}
		
		return (int)result;
		
	}
}
