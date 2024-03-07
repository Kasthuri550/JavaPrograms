package Arrayprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RepeatingElements {

	public static void main(String[] args) {

		int[] array = {4, 2, 3, 1, 2, 5, 3};
		repeatingElements1(array);
//		repeatingElements2(array);
//		repeatingElements3(array);
//		repeatingElements4(array);
//		repeatingElements5(array);
//		repeatingElements6(array);
//		repeatingElements7(array);
	}

	private static void repeatingElements7(int[] array) {
		
		int arrayLength=array.length;
		int freqArray[]=new int[arrayLength];
		for(int i=0;i<arrayLength;i++)
		{
			freqArray[array[i]]++;
		}
		for(int j=0;j<freqArray.length;j++)
		{
			if(freqArray[array[j]]>1)
			{
				System.out.println(array[j]);
				freqArray[array[j]]=0;
			}
		}
		
	}

	private static void repeatingElements6(int[] array) {
		
		int arrayLength=array.length;
		HashMap<Integer, Integer> hashMap=new HashMap<Integer, Integer>();
		for(int i=0;i<arrayLength;i++)
		{
			if(hashMap.containsKey(array[i]))
			{
//				hashMap.put(array[i],hashMap.get(array[i])+1);
				System.out.println(array[i]);
			}
			else
			{
				hashMap.put(array[i],1);
			}
		}
		
	}

	private static void repeatingElements5(int[] array) {
		
		int arrayLength=array.length;
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		
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

	private static void repeatingElements4(int[] array) {
		
		int arrayLength=array.length;	
		Arrays.sort(array);
		
		for(int i=0;i<arrayLength-1;i++)
		{
			if(array[i]==array[i+1])
			{
				System.out.println(array[i]);
			}
		}
		
	}

	private static void repeatingElements3(int[] array) {
		
		int arrayLength=array.length;		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<arrayLength;i++)
		{
			if(!hashSet.add(array[i]))
			{
				System.out.println(array[i]);
			}
		}
		
	}

	private static void repeatingElements2(int[] array) {
		
		int arrayLength=array.length;

		for(int i=0;i<arrayLength;i++)
		{
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
				for(int j=i+1;j<arrayLength;j++)
				{
					if(array[i]==array[j])
					{
						System.out.println(array[j]);
						break;
					}
				}
			}

		}

	}

	//	O(n) and O(1)
	private static void repeatingElements1(int[] array) {

		int arrayLength=array.length;

		for(int i=0;i<arrayLength;i++)
		{
			for(int j=i+1;j<arrayLength;j++)
			{
				if(array[i]==array[j])
				{
					System.out.println(array[j]);
				}
			}
		}

	}

}
