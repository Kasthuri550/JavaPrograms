package Arrayprograms.medium;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarraySum0 {

	public static void main(String[] args) {
		
		int arr[] = {15,-2,2,-8,1,7,10,23};
		
//		largestSubarrayBrute(arr);
//		largestSubarrayBetter(arr);
		largestSubarrayOptimal(arr);

	}

	private static void largestSubarrayOptimal(int[] arr) {
		
		int n=arr.length,sum=0,max=Integer.MIN_VALUE,start=-1,end=-1;
		
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			
			if(sum==0)
			{
				max=i+1;
				start=0;
				end=i;
			}
			else
			{
				if(map.containsKey(sum))
				{
					if(max < i-map.get(sum))
					{
						max=i-map.get(sum);
						start=map.get(sum)+1;
						end=i;
					}
				}
				else
				{
					map.put(sum,i);
				}
			}
		}
		
		System.out.println(start+", "+end);
		System.out.println(max);
		
	}

	private static void largestSubarrayBetter(int[] arr) {
		
		 int n = arr.length;
		    int max = 0;
		    int start = -1, end = -1;

		    for (int i = 0; i < n; i++) {
		        int sum = 0;
		        for (int j = i; j < n; j++) {
		            sum += arr[j];
		            if (sum == 0 && j - i + 1 > max) {
		                max = j - i + 1;
		                start = i;
		                end = j;
		            }
		        }
		    }

		    if (start != -1 && end != -1) {
		        System.out.println("Start Index: " + start + ", End Index: " + end);
		    } else {
		        System.out.println("No subarray with sum 0 found.");
		    }
		
	}

	private static void largestSubarrayBrute(int[] arr) {
		
		int n=arr.length,max=Integer.MIN_VALUE,start=-1,end=-1;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}
				
				if(sum==0 && j-i+1>max)
				{
					max=j-i+1;
					start=i;
					end=j;
				}
			}
		}
		System.out.println("["+start+", "+end+"]");
		System.out.println(max);
	}
}
