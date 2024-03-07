package Arrayprograms;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {

		//		int arr[] = {7,1,5,3,6,4};
		int arr[]={100,180,260,310,40,535,695};
		//		maxProfit1(arr);
		//		maxProfit2(arr);
		maxProfit3(arr,arr.length);
	}

	private static void maxProfit3(int[] A,int n) {

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			if (A[i - 1] < A[i]) {
				List<Integer> pair = new ArrayList<>();
				pair.add(i - 1);
				pair.add(i);
				ans.add(pair);
			}
		}

		System.out.println(ans);
	}

	private static void maxProfit2(int[] arr) {

		int n=arr.length,min=arr[0],max=Integer.MIN_VALUE;

		for(int i=1;i<n;i++)
		{
			int cost=arr[i]-min;
			max=Math.max(max,cost);
			min=Math.min(min,arr[i]);
		}

		System.out.println(max);
	}

	private static void maxProfit1(int[] arr) {

		int n=arr.length,max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					max=Math.max(arr[j]-arr[i],max);
				}
			}
		}

		System.out.println(max);
	}
}
