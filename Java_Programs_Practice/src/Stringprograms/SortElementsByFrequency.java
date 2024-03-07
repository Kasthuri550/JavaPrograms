package Stringprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortElementsByFrequency {

	public static void main(String[] args) {
		
		int[] arr = {4, 4, 5, 6, 4, 5, 6, 7, 7, 7};
		sortFrequency(arr);
	}

	private static void sortFrequency(int[] arr) {
		
		int n=arr.length;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}
		
		List<Map.Entry<Integer, Integer>> list=new ArrayList<>(map.entrySet());
		System.out.println(list);
		Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {
			
			public int compare(Map.Entry<Integer, Integer> m1,Map.Entry<Integer, Integer> m2)
			{
				int frequency = m2.getValue().compareTo(m1.getValue());
				
				if(frequency==0)
				{
					return m2.getKey().compareTo(m1.getKey());
				}
				else
				{
					return frequency;
				}
			}
		});
		
		System.out.println(list);
		
	}

}
