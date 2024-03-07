package Arrayprograms.hard;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		
//		pascalvariation1();
//		pascalvariation2Brute();
//		pascalvariation2optimal();
//		pascalvariation3brute();
		pascalvariation3optimal();
	}

	private static void pascalvariation3optimal() {
		
		int n=5;
		
		ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
		
		for(int row=1;row<=n;row++)
		{
			temp.add(generateRow(row));
		}
		
		System.out.println(temp);
		
	}

	private static ArrayList<Integer> generateRow(int row) {
		
		int result=1;
		ArrayList<Integer> ans=new ArrayList<>();
		ans.add(result);
		
		for(int col=1;col<row;col++)
		{
			result=result*(row-col);
			result=result/(col);
			ans.add(result);			
		}
		
		return ans;
	}

	private static void pascalvariation3brute() {
		
		int n=5;
		ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
		
		for(int row=1;row<=n;row++)
		{
			ArrayList<Integer> ans=new ArrayList<>();
			for(int col=1;col<=row;col++)
			{
				ans.add(nCr(row-1,col-1));
			}
			temp.add(ans);
		}
		
		System.out.println(temp);
		
	}

	private static int nCr(int n, int r) {
		
		int result=1;
				
		for(int i=0;i<r;i++)
		{
			result=result*(n-i);
			result=result/(i+1);
		}
		
		return result;
	}

	private static void pascalvariation2optimal() {
		
		int n=5;
		long result=1;
		System.out.println(result);
		for(int i=1;i<n;i++)
		{
			result=result*(n-i);
			result=result/i;
			System.out.println(result);
		}
		
	}

	private static void pascalvariation2Brute() {
		
		int n=5;
		
		for(int c=1;c<=n;c++)
		{
			System.out.println(generateElement(n-1,c-1));
		}
		
	}

	private static long generateElement(int n, int c) {
		
		long result=1;
		
		for(int i=0;i<c;i++)
		{
			result=result*(n-i);
			result=result/(i+1);
		}
		
		return result;		
	}

	private static void pascalvariation1() {
		
		int r=5,c=3,result=1;
		
		for(int i=0;i<c-1;i++)
		{
			result=result*(r-1-i);
			result=result/(i+1);
		}
		
		System.out.println(result);
	}

}
