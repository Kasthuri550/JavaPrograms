package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {

		int[] arr = { -1, 0, 1, 2, -1, -4};
		int n = arr.length;

		sum3brute(arr,n);
		sum3better(arr,n);
		sum3optimal(arr,n);
	}

	/*
	 * Time Complexity: O(n^2 * nlogn)
	 * Space Complexity: O(no. of unique triplets)
	 * */
	private static void sum3optimal(int[] arr, int n) {

		List<List<Integer>> temp=new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<n;i++)
		{
			if(i!=0 && arr[i]==arr[i-1]) continue;

			int j=i+1,k=n-1;
			while(j<k)
			{
				int sum=arr[i]+arr[j]+arr[k];

				if(sum < 0)
				{
					j++;
				}
				else if(sum > 0)
				{
					k--;
				}
				else {
					List<Integer> list=Arrays.asList(arr[i],arr[j],arr[k]);
					temp.add(list);
					j++;
					k--;

					while(j<k && arr[j]==arr[j-1]) j++;
					while(j<k && arr[k]==arr[k+1]) k--;
				}
			}
		}

		System.out.println(temp);
	}
	/*
	 * Time Complexity: O(n^2 * log(no. of unique triplets))
	 * Space Complexity: O(2*(no. of unique triplets))
	 * */
	private static void sum3better(int[] arr, int n) {

		Set<List<Integer>> temp=new HashSet<List<Integer>>();
		for(int i=0;i<n;i++)
		{
			Set<Integer> hashset=new HashSet<Integer>();
			for(int j=i+1;j<n;j++)
			{
				int sum=-(arr[i]+arr[j]);

				if(hashset.contains(sum))
				{
					List<Integer> list=Arrays.asList(arr[i],arr[j],sum);
					list.sort(null);
					temp.add(list);
				}

				hashset.add(arr[j]);
			}
		}	

		List<List<Integer>> alist=new ArrayList<>(temp);
		System.out.println(alist);
	}
	/*
	 * Time Complexity: O(n^3 * log(no. of unique triplets))
	 * Space Complexity: O(2*(no. of unique triplets))
	 * */
	private static void sum3brute(int[] arr, int n) {

		Set<List<Integer>> set=new HashSet<List<Integer>>();

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					if(arr[i]+arr[j]+arr[k]==0)
					{
						List<Integer> temp=Arrays.asList(arr[i],arr[j],arr[k]);
						temp.sort(null);
						set.add(temp);
					}
				}
			}
		}

		List<List<Integer>> list=new ArrayList<>(set);
		System.out.println(list);
	}
}
