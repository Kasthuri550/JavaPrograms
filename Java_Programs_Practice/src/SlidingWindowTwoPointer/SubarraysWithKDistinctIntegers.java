package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraysWithKDistinctIntegers {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 1, 2, 3}, k = 2;
		
		System.out.println(subarraysWithKDistinctIntegersBrute(arr,k));
		System.out.println(subarraysWithKDistinctIntegersBetter(arr, k)-subarraysWithKDistinctIntegersBetter(arr, k-1));

	}

	private static int subarraysWithKDistinctIntegersBetter(int[] arr, int k) {

		int left=0,right=0,count=0,n=arr.length;
		
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		
		while(right<n)
		{
			hashMap.put(arr[right],hashMap.getOrDefault(arr[right],0)+1);
			right++;
			
			while(hashMap.size()>k)
			{
				hashMap.put(arr[left],hashMap.getOrDefault(arr[left],0)-1);
				if(hashMap.get(arr[left])==0)
				{
					hashMap.remove(arr[left]);
				}
				left++;
			}
			
			count+=right-left;
		}
		
		return count;
	}

	private static int subarraysWithKDistinctIntegersBrute(int[] arr, int k) {
		
		int n=arr.length,count=0;
		
		for(int i=0;i<n;i++)
		{
			HashSet<Integer> hashSet=new HashSet<Integer>();
			for(int j=i;j<n;j++)
			{
				hashSet.add(arr[j]);
				
				if(hashSet.size()==k)
				{
					count++;
				}
				
				if(hashSet.size()>k)
				{
					break;
				}
			}
		}
		
		return count;
	}
}
