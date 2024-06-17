package Arrayprograms.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {

		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		
		System.out.println(majorityElement1(arr));
		System.out.println(majorityElement2(arr));
		System.out.println(majorityElement3(arr));
		
	}

	private static int majorityElement3(int[] arr) {
		
		int n=arr.length,count=0,element=0;
		
		for(int i=0;i<n;i++)
		{
			if(count==0)
			{
				count=1;
				element=arr[i];
			}
			else if(element==arr[i])
			{
				count++;
			}
			else
			{
				count--;
			}
		}
		
		int count1=0;
		for(int i=0;i<n;i++)
		{
			if(element==arr[i])
			{
				count1++;
			}
		}
		
		if(count1>(n/2))
		{
			return element;
		}
		
		return -1;
	}

	private static int majorityElement2(int[] arr) {
		
		int n=arr.length;
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue()>(n/2))
			{
				return entry.getKey();
			}
		}
		return -1;
	}

	private static int majorityElement1(int[] arr) {
		
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
			
			if(count>(n/2))
			{
				return arr[i];
			}
		}
		
		return -1;		
	}
}
