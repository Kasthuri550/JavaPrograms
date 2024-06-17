package Arrayprograms.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementN2 {

	public static void main(String[] args) {
		
		 int[] arr = {2, 2, 1, 1, 1, 2, 2};
		  
		 System.out.println(majorityElementBrute(arr));
		 System.out.println(majorityElementBetter(arr));
		 System.out.println(majorityElementOptimal(arr));

	}

	private static int majorityElementOptimal(int[] arr) {
		
		int n=arr.length,count=0,element = 0;
		
		for(int i=0;i<n;i++)
		{
			if(count==0)
			{
				count=1;
				element=arr[i];
			}
			else if(arr[i]==element)
			{
				count++;
			}
			else
			{
				count--;
			}
		}
		
		count=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==element)
			{
				count++;
			}
		}
		
		if(count>n/2)
		{
			return element;
		}
		
		return -1;
	}

	private static int majorityElementBetter(int[] arr) {
		
		int n=arr.length;
		
		Map<Integer,Integer> frequencyMap=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			frequencyMap.put(arr[i],frequencyMap.getOrDefault(arr[i],0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry:frequencyMap.entrySet())
		{
			if(entry.getValue()>n/2)
			{
				return entry.getKey();
			}
		}
		
		return -1;
	}

	private static int majorityElementBrute(int[] arr) {
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
			
			if(count>n/2)
			{
				return arr[i];
			}
		}
		
		return -1;		
	}
}
