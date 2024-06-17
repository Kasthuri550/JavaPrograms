package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {

		 int[] arr = {1, 2 ,3 ,1, 4 ,5, 2, 3, 6};
		 int k=3;
		
		maximumKSubarrayBrute(arr,k);
		maximumKSubarrayOptimal(arr, k);
	}

	private static void maximumKSubarrayOptimal(int[] arr, int k) {
		
		int n=arr.length;
		
		int r[]=new int[n-k+1];
		
		Deque<Integer> deque=new ArrayDeque<Integer>();
		int ri=0;
		
		for(int i=0;i<n;i++)
		{
			if(!deque.isEmpty() && deque.peek()==i-k)
			{
				deque.poll();
			}
			
			while(!deque.isEmpty() && arr[deque.peekLast()]<arr[i])
			{
				deque.pollLast();
			}
			
			deque.offer(i);
			
			if(i>=k-1)
			{
				r[ri++]=arr[deque.peek()];
			}
		}
		
		System.out.println(Arrays.toString(r));
		
	}

	private static void maximumKSubarrayBrute(int[] arr, int k) {
		
		int n=arr.length;
		 ArrayList<Integer> resultList = new ArrayList<>();
		
		
		for(int i=0;i<=n-k;i++)
		{
			int max=arr[i];
			for(int j=1;j<k;j++)
			{
				if(arr[i+j]>max)
				{
					max=arr[i+j];
				}
			}
			resultList.add(max);
		}
		
		System.out.println(resultList);
		
	}
}
