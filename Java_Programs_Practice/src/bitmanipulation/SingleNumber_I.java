package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_I {

	public static void main(String[] args) {

		int arr[] = {8, 8, 7, 7, 6, 6, 1};

		System.out.println(singleNumberBrute(arr));
		System.out.println(singleNumberOptimal(arr));	
	}
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * */
	private static int singleNumberOptimal(int[] arr) {

		int xor=0;

		for(int a:arr)
		{
			xor=xor^a;
		}

		return xor;
	}
	/*
	 * Time Complexity: O(n*log m)+O(m)
	 * Space Complexity: O(m)
	 * */
	private static int singleNumberBrute(int[] arr) {

		Map<Integer,Integer> map=new HashMap<>();

		for(int a:arr)
		{
			map.put(a,map.getOrDefault(a,0)+1);
		}

		for(Map.Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue()==1)
			{
				return entry.getKey();
			}
		}
		return 0;
	}
}
