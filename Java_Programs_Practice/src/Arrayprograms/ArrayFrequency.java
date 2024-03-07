package Arrayprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayFrequency {

	public static void main(String[] args) {
		
		int[] array = {1, 2, 3, 4, 2, 3, 1, 2, 4, 5, 1, 3, 4, 2, 5};
//		countArrayFrequency1(array);
//		countArrayFrequency2(array);
		countArrayFrequency3(array);
//		countArrayFrequency4(array);
//		countArrayFrequency5(array);
	}

	private static void countArrayFrequency5(int[] array) {
		
		for(int i=0;i<array.length;i++)
		{
			int count=1;
			boolean visited=false;
			for(int j=0;j<i;j++)
			{
				if(array[i]==array[j])
				{
					visited=true;
					break;
				}
			}
			
			if(!visited)
			{
				for(int k=i+1;k<array.length;k++)
				{
					if(array[i]==array[k])
					{
						count++;
					}
				}
				System.out.println(array[i]+" - "+count);
			}
		}
		
	}

	private static void countArrayFrequency4(int[] array) {
		
		Map<Integer, Long> collect = Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		collect.forEach((key,value) -> System.out.println(key+" - "+value));

	}

	private static void countArrayFrequency3(int[] array) {
		
		int count=1;
		
		Arrays.parallelSort(array);
		
		for(int i=1;i<array.length;i++)
		{
			if(array[i]==array[i-1])
			{
				count++;
			}
			else
			{
				System.out.println(array[i-1]+" - "+count);
				count=1;
			}
		}
		System.out.println(array[array.length-1]+" - "+count);
	}

	private static void countArrayFrequency2(int[] array) {
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int itr=0;itr<array.length;itr++)
		{
			if(map.containsKey(array[itr]))
			{
				map.put(array[itr],map.get(array[itr])+1);
			}
			else
			{
				map.put(array[itr],1);
			}
		}
		
		map.forEach((key,value) -> System.out.println(key+" - "+value));
		
	}

	private static void countArrayFrequency1(int[] array) {
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int itr=0;itr<array.length;itr++)
		{
			map.put(array[itr],map.getOrDefault(array[itr],0)+1);
		}
		
		
		map.forEach((key,value)  -> System.out.println(key+" - "+value));
	}
}
