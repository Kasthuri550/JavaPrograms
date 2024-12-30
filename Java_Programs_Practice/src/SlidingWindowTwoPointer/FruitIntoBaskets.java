package SlidingWindowTwoPointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {

	public static void main(String[] args) {

		int arr[] = {3, 1, 2, 2, 2, 2},k=2;

		System.out.println(fruitIntoBasketsBrute(arr,k));
		System.out.println(fruitIntoBasketsBetter(arr,k));
		System.out.println(fruitIntoBasketsOptimal(arr, k));

	}

	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */	
	private static int fruitIntoBasketsOptimal(int[] arr, int k) {

		int n=arr.length,left=0,right=0,maxLength=Integer.MIN_VALUE;

		Map<Integer,Integer> map=new HashMap<>();

		while(right<n)
		{
			map.put(arr[right],map.getOrDefault(arr[right],0)+1);

			if(map.size()>k)
			{
				map.put(arr[left],map.get(arr[left])-1);

				if(map.get(arr[left])==0)
					map.remove(arr[left]);

				left++;
			}

			maxLength=Math.max(maxLength,right-left+1);

			right++;
		}

		return maxLength;
	}

	/*
	 * Time Complexity: O(2*n)
	 * Space Complexity: O(3)
	 */	
	private static int fruitIntoBasketsBetter(int[] arr,int k) {

		int n=arr.length,left=0,right=0,maxLength=Integer.MIN_VALUE;

		Map<Integer,Integer> map=new HashMap<>();

		while(right<n)
		{
			map.put(arr[right],map.getOrDefault(arr[right],0)+1);

			while(map.size()>k)
			{
				map.put(arr[left],map.get(arr[left])-1);

				if(map.get(arr[left])==0)
					map.remove(arr[left]);

				left++;
			}

			maxLength=Math.max(maxLength,right-left+1);

			right++;
		}

		return maxLength;
	}

	/*
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(3)
	 */	
	private static int fruitIntoBasketsBrute(int[] arr,int k) {

		int n=arr.length,maxLength=Integer.MIN_VALUE;

		for(int i=0;i<n;i++)
		{
			Set<Integer> set=new HashSet<>();
			for(int j=i;j<n;j++)
			{
				set.add(arr[j]);

				if(set.size()<=k)
				{
					maxLength=Math.max(maxLength,j-i+1);
				}
				else
				{
					break;
				}
			}
		}

		return maxLength;
	}
}
