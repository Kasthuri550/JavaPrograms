package faq;

import java.util.Arrays;
import java.util.HashMap;

public class Program7 {

	public static void main(String[] args) {
		
		int[] array1 = {5, 2, 1, 4, 3};
        int[] array2 = {1, 2, 3, 4, 5,6};
        
        System.out.println(approach1(array1,array2));
        System.out.println(approach2(array1,array2));

	}

	private static boolean approach2(int[] array1, int[] array2) {
		
		HashMap<Integer,Integer> hashmap=new HashMap<Integer, Integer>();
		
		for(int i=0;i<array1.length;i++)
		{
			hashmap.put(array1[i],hashmap.getOrDefault(array1[i],0)+1);
		}
		for(int j=0;j<array2.length;j++)
		{
			if(!hashmap.containsKey(array2[j]))
			{
				return false;
			}
			int count=hashmap.get(array2[j]);
			if(count==0)
			{
				return false;
			}
			hashmap.put(array2[j],count-1);
			
		}
		return true;
	}

	private static boolean approach1(int[] array1, int[] array2) {
		
		if(array1.length!=array2.length)
		{
			return false;
		}
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		for(int i=0;i<array1.length;i++)
		{
			if(array1[i]!=array2[i])
			{
				return false;
			}
		}
		
		return true;
	}

}
