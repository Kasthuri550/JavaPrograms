package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximumPractice {

	public static void main(String[] args) {

		int arr[]={4,0,-1,3,5,3,6,8},k=3;

		slidingWindowMaximumBrute(arr,k);
		slidingWindowMaximumBetter(arr,k);
		slidingWindowMaximumOptimal(arr,k);
	}

	private static void slidingWindowMaximumOptimal(int[] arr, int k) {

		int n=arr.length;
		int result[]=new int[n-k+1],index=0;
		Deque<Integer> deque=new ArrayDeque<Integer>();

		for(int i=0;i<n;i++)
		{
			if(!deque.isEmpty() && arr[deque.peek()]==i-k)
			{
				deque.poll();
			}

			while(!deque.isEmpty() && arr[i]> arr[deque.peekLast()])
			{
				deque.pollLast();
			}
			deque.offer(i);
			if(i>=k-1)
			{
				result[index++]=arr[deque.peek()];
			}
		}
		System.out.println(Arrays.toString(result));
	}

	private static void slidingWindowMaximumBrute(int[] arr, int k) {

		int n=arr.length;

		ArrayList<Integer> resultList=new ArrayList<Integer>();

		for(int i=0;i<=n-k;i++)
		{
			int max=Integer.MIN_VALUE;
			for(int j=i;j<i+k;j++)
			{
				for(int m=i;m<=j;m++)
				{
					max=Math.max(max,arr[m]);
				}
			}
			resultList.add(max);
		}

		System.out.println(resultList);

	}

	private static  void slidingWindowMaximumBetter(int[] arr,int k) {

		int n=arr.length;

		ArrayList<Integer> resultList=new ArrayList<Integer>();

		for(int i=0;i<=n-k;i++)
		{
			int max=Integer.MIN_VALUE;
			for(int j=i;j<i+k;j++)
			{
				max=Math.max(max,arr[j]);
			}

			resultList.add(max);
		}

		System.out.println(resultList);
	}
}
