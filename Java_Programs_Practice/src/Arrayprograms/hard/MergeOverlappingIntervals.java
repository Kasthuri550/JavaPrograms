package Arrayprograms.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		
		int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
		
//		mergeOverlappingBrute(arr,arr.length);
		mergeOverlappingOptimal(arr,arr.length);
	}

	private static void mergeOverlappingOptimal(int[][] arr, int n) {
		
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		List<List<Integer>> list=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(list.isEmpty()||arr[i][0]>list.get(list.size()-1).get(1))
			{
				list.add(Arrays.asList(arr[i][0],arr[i][1]));
			}
			else
			{
				list.get(list.size()-1).set(1,Math.max(list.get(list.size()-1).get(1),arr[i][1]));
			}
		}
		
		System.out.println(list);		
	}

	private static void mergeOverlappingBrute(int[][] arr, int n) {
		
		
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		List<List<Integer>> list=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			int start=arr[i][0];
			int end=arr[i][1];
			
			if(!list.isEmpty() && end<=list.get(list.size()-1).get(1))
			{
				continue;
			}
			
			for(int j=i+1;j<n;j++)
			{
				if(arr[j][0]<=end)
				{
					end=Math.max(end,arr[j][1]);
				}
				else
				{
					break;
				}
			}
			list.add(Arrays.asList(start,end));
		}
		
		System.out.println(list);
	}
}
