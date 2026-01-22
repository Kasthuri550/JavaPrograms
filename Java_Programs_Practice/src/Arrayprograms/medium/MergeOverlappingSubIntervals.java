package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {

	public static void main(String[] args) {

		int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};

		mergeOverlappingBrute(arr);
		mergeOverlappingOptimal(arr);
	}

	/*
	 * Time Complexity: O(n + nlogn)
	 * Space Complexity: O(n)
	 * */
	private static void mergeOverlappingOptimal(int[][] arr) {

		Arrays.sort(arr,(a,b)->a[0]-b[0]);

		int n=arr.length;
		List<List<Integer>> resultList=new ArrayList<List<Integer>>();

		for(int i=0;i<n;i++)
		{
			if(resultList.isEmpty()||arr[i][0]>resultList.get(resultList.size()-1).get(1))
			{
				resultList.add(Arrays.asList(arr[i][0],arr[i][1]));
			}
			else
			{
				resultList.get(resultList.size()-1).set(1,Math.max(resultList.get(resultList.size()-1).get(1),arr[i][1]));
			}
		}

		System.out.println(resultList);
	}

	/*
	 * Time Complexity: O(n^2 + nlogn)
	 * Space Complexity: O(n)
	 * */	
	private static void mergeOverlappingBrute(int[][] arr) {

		Arrays.sort(arr,(a,b)->a[0]-b[0]);

		int n=arr.length;

		List<List<Integer>> resultList=new ArrayList<>();

		for(int i=0;i<n;i++)
		{
			int start=arr[i][0];
			int end=arr[i][1];

			if(!resultList.isEmpty() && start<=resultList.get(resultList.size()-1).get(1))
			{
				continue;
			}

			for(int j=i+1;j<n;j++)
			{
				if(arr[j][0]<=end)
				{
					end=Math.max(arr[j][1], end);
				}
				else
				{
					break;
				}
			}
			resultList.add(Arrays.asList(start,end));
		}

		System.out.println(resultList);
	}
}
