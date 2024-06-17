package Arrayprograms.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarrayWith0Sum {

	public static void main(String[] args) {
		
//		int[] arr = {4, 2, -3, 1, 6};
		int arr[] = {15,-2,2,-8,1,7,10,23,0};
		
//		sum0Brute(arr);
//		sum0Better1(arr);
//		sum0Better2(arr);
		sum0Optimal(arr);
	}

	private static void sum0Optimal(int[] arr) {
		
		int n=arr.length,sum=0;
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			
			if(arr[i]==0 || sum==0 || map.containsKey(sum))
			{
				System.out.println(i);
			}
			else
			{
				map.put(sum,i);
			}
		}
		
	}

	private static void sum0Better2(int[] arr) {
		
		int n=arr.length,sum=0;
		
		Set<Integer> set=new HashSet<>();
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			
			if(arr[i]==0 || sum==0 || set.contains(sum))
			{
				System.out.println(i);
			}
			else
			{
				set.add(sum);
			}
		}
		
//		System.out.println("No subarray found with 0 sum");
		
	}

	private static void sum0Better1(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=arr[j];
				
				if(sum==0)
				{
					System.out.println(i+" "+j);
				}
			}
		}
		
	}

	private static void sum0Brute(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}
				
				if(sum==0)
				{
					System.out.println(i+" "+j);
				}
			}
		}
		
	}
}
