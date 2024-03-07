package Arrayprograms;

import java.util.ArrayList;

public class Leaders {

	public static void main(String[] args) {
		
		int arr[]=  {10, 22, 12, 3, 0, 6};
		
		superior1(arr,arr.length);
		superior2(arr,arr.length);
	}

	private static void superior2(int[] arr, int n) {
		
		int max=Integer.MIN_VALUE;
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for(int i=n-1;i>=0;i--)
		{
			if(arr[i]>max)
			{
				al.add(arr[i]);
			}
			
			max=Math.max(max,arr[i]);
		}
		
		System.out.println(al);
	}

	private static void superior1(int[] arr, int n) {
		
		ArrayList<Integer> al=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			boolean leader=true;
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]>arr[i])
				{
					leader=false;
					break;
				}
			}
			
			if(leader ==true)
			{
				al.add(arr[i]);
			}
		}
		
		System.out.println(al);
		
	}

}
