package Arrayprograms;

import java.util.HashMap;

public class SymmetricPairs {

	public static void main(String[] args) {
		
		int arr[][] = {{10,20}, {30,40}, {50,60}, {20,10}, {40,30}};
		
		sp1(arr);
		sp2(arr);
	}

	private static void sp2(int[][] arr) {
		
		int n=arr.length;
		
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			int first =arr[i][0];
			int second=arr[i][1];
			
			Integer value=map.get(second);
			
			if(value!=null && value==first)
			{
				System.out.println("( "+second+" , "+first+" )");
			}
			else
			{
				map.put(first,second);
			}
		}
		
	}

	private static void sp1(int[][] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i][0]==arr[j][1] && arr[i][1]==arr[j][0])
				{
					System.out.println("( "+arr[i][0]+" , "+arr[i][1]+" )");
				}
			}
		}
		
	}

}
