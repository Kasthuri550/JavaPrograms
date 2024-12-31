package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfSubarraysInTheRangeLToR {

	public static void main(String[] args) {
		
		int N = 3, L = 3, R = 8,A[] = {1, 4, 6};
		
		System.out.println(countTheNumberOfSubarraysInTheRangeLToRBrute(A,N,L,R));
		System.out.println(countTheNumberOfSubarraysInTheRangeLToRBetter(A,N,L,R));
		System.out.println(countTheNumberOfSubarraysInTheRangeLToROptimalI(A, N,R)-countTheNumberOfSubarraysInTheRangeLToROptimalI(A, N,L-1));
		System.out.println(countTheNumberOfSubarraysInTheRangeLToROptimalII(A,N,R)-countTheNumberOfSubarraysInTheRangeLToROptimalII(A,N,L-1));
	}

	/*
	 * Time Complexity: O(2n)
	 * Space Complexity: O(1)
	 */
	private static int countTheNumberOfSubarraysInTheRangeLToROptimalII(int[] a, int n, int target) {

		int left=0,right=0,sum=0,count=0;
		
		while(right<n)
		{
			sum=sum+a[right];
			
			while(sum>target && left<=right)
			{
				sum=sum-a[left];
				left++;
			}
			
			count+=(right-left+1);
			right++;
		}
		
		return count;
	}
	/*
	 * Time Complexity: O(n*target)
	 * Space Complexity: O(n)
	 */
	private static int countTheNumberOfSubarraysInTheRangeLToROptimalI(int[] a, int n, int target) {

		int prefixSum=0,count=0;
		
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0,1);
		
		for(int i=0;i<n;i++)
		{
			prefixSum=prefixSum+a[i];
			for (int j = 0; j <= target; j++) {
                count += map.getOrDefault(prefixSum - j, 0);
            }
			map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
		}
		
		return count;
	}
	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */
	private static int countTheNumberOfSubarraysInTheRangeLToRBetter(int[] a, int n, int l, int r) {

		int count=0;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum=sum+a[j];
				
				if(sum>=l && sum<=r)
					count++;
			}
		}
		
		return count;
	}
/*
 * Time Complexity: O(n^3)
 * Space Complexity: O(1)
 */
	private static int countTheNumberOfSubarraysInTheRangeLToRBrute(int[] a, int n, int l, int r) {

		int count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum=sum+a[k];
				}
				
				if(sum>=l && sum<=r)
					count++;
			}
		}
		
		return count;
	}
}
