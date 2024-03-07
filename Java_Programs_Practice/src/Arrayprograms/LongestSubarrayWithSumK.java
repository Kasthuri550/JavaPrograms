package Arrayprograms;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

	public static void main(String[] args) {
		
		int A[] = {10, 5, 2, 7, 1, 9};
		int K = 15;
		
//		longestSubarray1(A,K);
//		longestSubarray2(A, K);
//		longestSubarray3(A, K);
		longestSubarray4(A, K);
	}

	private static void longestSubarray4(int[] a, int k) {
		
		int n=a.length,max=0;
		
		int left=0,right=0;
		int sum=a[0];
		
		while(right < n)
		{
			while(left <= right && sum > k)
			{
				sum-=a[left];
				left++;
			}
			if(sum == k)
			{
				max=Math.max(max,right-left+1);
			}
			right++;
			if(right < n)
			{
				sum+=a[right];
			}
		}
		
		System.out.println(max);	
	}

	private static void longestSubarray3(int[] a, int k) {
		
		int n = a.length; 

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            long rem = sum - k;

            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        System.out.println(maxLen);
		
	}

	private static void longestSubarray2(int[] a, int k) {
		
		int n=a.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			int sum=0,j;
			for(j=i;j<n;j++)
			{
				sum+=a[j];
				if(sum == k)
				{
					max=Math.max(max,j-i+1);
				}
			}
		}
		
		System.out.println(max);
	}

	private static void longestSubarray1(int[] a, int k) {
		
		int n=a.length,max=Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int m=i;m<=j;m++)
				{
					sum+=a[m];
				}
				
				if(sum == k)
				{
					max=Math.max(max,j-i+1);
				}
			}
		}
		
		System.out.println(max);
	}

}
