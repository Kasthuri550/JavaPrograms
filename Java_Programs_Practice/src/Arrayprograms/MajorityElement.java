package Arrayprograms;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public static void main(String[] args) {

		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		System.out.println(majority1(arr));
		System.out.println(majority2(arr));
		System.out.println(majority3(arr));
	}

	private static int majority3(int[] arr) {
		
		int n=arr.length;
		
		int count=0,element = 0;
		
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
		int count1=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==element)
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

	private static Integer majority2(int[] arr) {
		
		int n=arr.length;
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		}
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			if(entry.getValue()>(n/2))
			{
				return entry.getKey();
			}
		}
		return -1;
	}

	private static int majority1(int[] arr) {
		
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(arr[i]==arr[j])
					count++;
			}
			
			if(count>(n/2))
			{
				return arr[i];
			}
		}	
		
		return -1;
	}
}
