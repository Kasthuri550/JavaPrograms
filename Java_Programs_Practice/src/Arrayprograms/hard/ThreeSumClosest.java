package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

	public static void main(String[] args) {

		int arr[] = {-1, 2, 2, 4}, target = 4;

		threeSumClosest(arr,target);
	}
	/*
	 * Time Complexity: O(n^2 * nlogn)
	 * Space Complexity: O(1)
	 * */
	private static void threeSumClosest(int[] arr, int target) {

		int n=arr.length;

		if(n<3)
			return;

		Arrays.sort(arr);

		int minDiff=Integer.MAX_VALUE;
		int closestSum=arr[0]+arr[1]+arr[2];

		List<List<Integer>> resultList=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			int j=i+1,k=n-1;
			while(j<k)
			{
				int sum=arr[i]+arr[j]+arr[k];
				int diff=Math.abs(sum-target);

				if(diff<minDiff || (diff==minDiff && sum>closestSum))
				{
					minDiff=diff;
					closestSum=sum;
					resultList.clear();
					List<Integer> list=new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[j]);
					list.add(arr[k]);
					resultList.add(list);
				}

				if(sum<target)
				{
					j++;
				}
				else
				{
					k--;
				}
			}
		}

		System.out.println(closestSum);
		System.out.println(resultList);
	}
}
