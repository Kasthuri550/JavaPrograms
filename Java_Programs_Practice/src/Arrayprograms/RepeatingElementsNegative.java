package Arrayprograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatingElementsNegative {

	public static void main(String[] args) {

		int[] array = {4, 2, -1, 2, -3, 4, 2, -3, -1};

//		repeatingNegative1(array);
		System.out.println(repeatingNegative2(array));
	}

	private static List<Integer> repeatingNegative2(int[] arr) {
		
		 List<Integer> repeatingElements = new ArrayList<>();

	        for (int i = 0; i < arr.length; i++) {
	            int index = Math.abs(arr[i]) - 1;
	            
	            // Check if the element at this index is negative
	            if (arr[index] < 0) {
	                repeatingElements.add(Math.abs(arr[i]));
	            } else {
	                arr[index] = -arr[index];
	            }
	        }

	        return repeatingElements;
	}

	private static void repeatingNegative1(int[] array) {
		
		int arrayLength=array.length;
		HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		
		for(int i=0;i<arrayLength;i++)
		{
			hashMap.put(array[i],hashMap.getOrDefault(array[i], 0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entrySet:hashMap.entrySet())
		{
			if(entrySet.getValue()>1)
			{
				System.out.println(entrySet.getKey());
			}
			
		}	
	}
}
