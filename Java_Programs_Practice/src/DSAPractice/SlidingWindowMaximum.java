package DSAPractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

		int arr[]= {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3;
		
		slidingWindowMaximumBrute(arr,k);
		slidingWindowMaximumOptimal(arr, k);
	}

	private static void slidingWindowMaximumOptimal(int[] arr, int k) {
		
		int n=arr.length;
		
		Deque<Integer> deque=new ArrayDeque<Integer>();
		
		int subArrayMax[]=new int[n-k+1],index=0;
		
		for(int i=0;i<n;i++)
		{
			if(!deque.isEmpty() && deque.peek()==i-k)
				deque.poll();
			
			while(!deque.isEmpty() && arr[deque.peekLast()]<arr[i])
			{
				deque.pollLast();
			}
			
			deque.offer(i);
			
			if(i>=k-1)
			{
				subArrayMax[index++]=arr[deque.peek()];
			}
			
		}
		
		System.out.println(Arrays.toString(subArrayMax));
		
	}

	private static void slidingWindowMaximumBrute(int[] arr, int k) {

		int n=arr.length,max=Integer.MIN_VALUE;
		
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=0;i<=n-k;i++)
		{
			for(int j=i;j<i+k;j++)
			{
				if(arr[j]>max)
				{
					max=arr[j];
				}
			}
			list.add(max);
		}
		
		System.out.println(list);
	}
}
