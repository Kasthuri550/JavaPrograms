package ArrayPractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        kthSmallestBrute(arr,k);
        kthSmallestBetter(arr,k);
	}

	private static void kthSmallestBetter(int[] arr, int k) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->b-a);
		
		for(int nums:arr)
		{
			pq.add(nums);
			
			if(pq.size()>k)
				pq.poll();
		}
		
		System.out.println(pq.peek());
	}

	private static void kthSmallestBrute(int[] arr, int k) {
		
		Arrays.sort(arr);
		
		System.out.println(arr[k-1]);
		
	}
}
