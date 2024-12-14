package ArrayPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByAnotherArray {

	public static void main(String[] args) {

		int[] arr1 = {7,1, 2, 3, 4, 3, 2, 4, 2, 5};
        int[] arr2 = {4, 2, 1, 3};
        
        sortArrayByAnotherArray(arr1,arr2);
	}

	private static void sortArrayByAnotherArray(int[] arr1, int[] arr2) {
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr2.length;i++)
		{
			map.put(arr2[i],i);
		}
		
		Integer array[]=new Integer[arr1.length];
		for(int i=0;i<arr1.length;i++)
		{
			array[i]=arr1[i];
		}
		
		Arrays.sort(array,(a1,a2)->
		{	
			if(map.containsKey(a1) && map.containsKey(a2))
			{
				return map.get(a1)-map.get(a2);
			}
			else if(map.containsKey(a1))
			{
				return -1;
			}
			else if(map.containsKey(a2))
			{
				return 1;
			}
			else
			{
				return a1-a2;
			}
		});
		
		System.out.println(Arrays.toString(array));
	}
}
