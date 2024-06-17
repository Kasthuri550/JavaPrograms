package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSum {

	public static void main(String[] args) {
		
		int[] arr = { -1, 0, 1, 2, -1, -4};
		
		sum3Brute(arr);
		sum3Better(arr);
		sum3Optimal(arr);

	}

	private static void sum3Optimal(int[] arr) {
		
		int n=arr.length;
		
		List<List<Integer>> resultList=new ArrayList<List<Integer>>();
		
		Arrays.sort(arr);
		
		for(int i=0;i<n;i++)
		{
			if(i!=0 && arr[i]==arr[i-1]) continue;
				
			int j=i+1,k=n-1;
			
			while(j<k)
			{
				int sum=arr[i]+arr[j]+arr[k];
				
				if(sum<0)
				{
					j++;
				}
				else if(sum>0)
				{
					k--;
				}
				else
				{
					List<Integer> list=Arrays.asList(arr[i],arr[j],arr[k]);
					resultList.add(list);
					j++;
					k--;
					while(j<k && arr[j]==arr[j-1]) j++;
					while(j<k && arr[k]==arr[k+1]) k--;
					
				}
			}
		}
		
		System.out.println(resultList);
		
	}

	private static void sum3Better(int[] arr) {
		
		int n=arr.length;
		
		Set<List<Integer>> set=new HashSet<List<Integer>>();
		
		for(int i=0;i<n;i++)
		{
			HashSet<Integer> hashSet=new HashSet<Integer>();
			for(int j=i+1;j<n;j++)
			{
				int k=-(arr[i]+arr[j]);
				
				if(hashSet.contains(k))
				{
					List<Integer> list=Arrays.asList(arr[i],arr[j],k);
					list.sort(null);
					set.add(list);
				}
				
				hashSet.add(arr[j]);
			}
		}
		
		System.out.println(set);
		
	}

	private static void sum3Brute(int[] arr) {
		
		int n=arr.length;
		
		Set<List<Integer>> set=new HashSet<>();
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					int sum=arr[i]+arr[j]+arr[k];
					
					if(sum==0)
					{
						List<Integer> list=Arrays.asList(arr[i],arr[j],arr[k]);
						list.sort(null);
						set.add(list);						
					}
				}
			}
		}
		
		System.out.println(set);
		
	}
}
