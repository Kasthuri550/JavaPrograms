package ArrayPractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
		
		int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        kthLargestBrute(arr,k);
        kthLargestBetter(arr, k);

	}

	private static void kthLargestBetter(int[] arr, int k) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		
		for(int num:arr)
		{
			pq.add(num);
			
			if(pq.size()>k)
				pq.poll();
		}
		
		System.out.println(pq.peek());
	}

	private static void kthLargestBrute(int[] arr, int k) {
		
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-k]);
	}
}
