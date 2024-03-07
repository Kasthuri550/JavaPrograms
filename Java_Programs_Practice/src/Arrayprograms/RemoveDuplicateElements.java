package Arrayprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		
		int arr[] = {8,1,2,9,3,0,4,5};
		removeDuplicates1(arr);
//		removeDuplicates2(arr);
//		removeDuplicates3(arr);
	}

	private static void removeDuplicates3(int[] arr) {
		
		int n=arr.length,j=0;
		
//		int temp[]=new int[n];
		
		Arrays.sort(arr);
		
		for(int i=0;i<n-1;i++)
		{
			if(arr[i]!=arr[i+1])
			{
//				temp[j++]=arr[i];
				arr[j++]=arr[i];
			}
		}
		
//		temp[j++]=arr[n-1];
		arr[j++]=arr[n-1];
		
//		System.out.println(Arrays.toString(temp));
		System.out.println(Arrays.toString(arr));
	}

	private static void removeDuplicates2(int[] arr) {
		
		int arrLength=arr.length;
		Map<Integer,Integer> hashMap=new HashMap<Integer,Integer>();	
		
		for(int i=0;i<arrLength;i++)
		{
			hashMap.put(arr[i],hashMap.getOrDefault(arr[i], 0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:hashMap.entrySet())
		{
			System.out.println(entry.getKey());
		}
	}

	private static void removeDuplicates1(int[] arr) {
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<arr.length;i++)
		{
			hashSet.add(arr[i]);
		}	
		for(Object j:hashSet.toArray())
		{
			System.out.print((int)j+" ");
		}
	}
}
