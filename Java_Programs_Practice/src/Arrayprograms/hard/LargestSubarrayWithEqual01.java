package Arrayprograms.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqual01 {

	public static void main(String[] args) {
		
		int arr[]={0,1,0,1};
		
		largestSubarray(arr);

	}

	private static void largestSubarray(int[] arr) {
		
		int n=arr.length,max=0,sum=0;
		
		Map<Integer,Integer> frequencyMap=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i]==0?-1:1;
			
			if(sum==0)
				max=i+1;
			
			if(frequencyMap.containsKey(sum))
			{
				max=Math.max(max,i-frequencyMap.get(sum));
			}
			else
			{
				frequencyMap.put(sum,i);
			}
		}
		
		System.out.println(max);
		
	}
}
