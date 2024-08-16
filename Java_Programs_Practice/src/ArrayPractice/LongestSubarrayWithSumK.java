package ArrayPractice;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

	public static void main(String[] args) {
		
		int[] a = {2, 3, 5, 1, 9};
        int k = 10;
        
//        longestSubarrayBrute1(a,a.length,k);
//        longestSubarrayBrute2(a,a.length,k);
//        longestSubarrayBetter(a,a.length,k);
        longestSubarrayOptimal(a,a.length,k);
	}

	private static void longestSubarrayOptimal(int[] a, int n, int k) {
		
		int left=0,right=0,sum=a[0],max=0;
		
		while(right<n)
		{
			while(left<=right && sum>k)
			{
				sum-=a[left];
				left++;
			}
			
			if(sum==k)
				max=Math.max(max,right-left+1);
				
			right++;
			if(right<n)
				sum+=a[right];
		}
		
		System.out.println(max);
	}

	private static void longestSubarrayBetter(int[] a, int n, int k) {
		
		int sum=0,max=0;
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			sum+=a[i];
			
			if(sum==k)
				max=Math.max(max,i+1);
			
			int rem=sum-k;
			
			if(hashMap.containsKey(rem))
				max=Math.max(max,i-hashMap.get(rem));
			
			if(!hashMap.containsKey(sum))
				hashMap.put(sum,i);
		}
		
		System.out.println(max);
	}

	private static void longestSubarrayBrute2(int[] a, int n, int target) {
		
		int max=0;
		
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=a[j];
				
				if(sum==target)
					max=Math.max(max,j-i+1);
			}
		}
		
		System.out.println(max);
	}

	private static void longestSubarrayBrute1(int[] a, int n, int target) {
		
		int max=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				
				for(int k=i;k<=j;k++)
				{
					sum+=a[k];
				}
				
				if(sum==target)
					max=Math.max(max,j-i+1);
			}
		}
		
		System.out.println(max);
	}
}
