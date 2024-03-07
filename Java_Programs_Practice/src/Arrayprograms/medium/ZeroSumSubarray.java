package Arrayprograms.medium;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubarray {

	public static void main(String[] args) {
		
		int n = 6;
		long arr[] = {0,0,5,5,0,0};
		System.out.println(findSubarray(arr,n));
	}
	
	 public static long findSubarray(long[] arr ,int n) 
	    {
	        long sum=0,count=0;
	        Map<Long,Integer> map=new HashMap<>();
	        
	        for(int i=0;i<n;i++)
	        {
	            sum+=arr[i];
	            
	            if(sum==0)
	                count++;
	            
	            if(map.containsKey(sum))
	            {
	                count+=map.get(sum);
	            }
	            
	            map.put(sum,map.getOrDefault(sum,0)+1);
	        }
	        
	        return count;
	    }
}
