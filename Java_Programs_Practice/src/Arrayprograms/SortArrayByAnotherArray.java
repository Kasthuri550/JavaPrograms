package Arrayprograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SortArrayByAnotherArray {

	public static void main(String[] args) {
		
		int[] arr1 = {7,1, 2, 3, 4, 3, 2, 4, 2, 5};
        int[] arr2 = {4, 2, 1, 3};

//		sortByAnotherArray1(arr1,arr2);
		sortByAnotherArray2(arr1,arr2);
	}

	private static void sortByAnotherArray2(int[] arr1, int[] arr2) {
		
		int n=arr1.length;
		int m=arr2.length;
		Map<Integer,Integer> indexMap=new HashMap<Integer, Integer>();
		
		for(int i=0;i<m;i++)
		{
			indexMap.putIfAbsent(arr2[i],i);
		}
		Integer arrWrapper[]=new Integer[n];
		for(int j=0;j<n;j++)
		{
			arrWrapper[j]=arr1[j];
		}
		Arrays.sort(arrWrapper,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				if(indexMap.containsKey(o1) && indexMap.containsKey(o2))
				{
					return indexMap.get(o1)-indexMap.get(o2);
				}
				else if(indexMap.containsKey(o1))
				{
					return -1;
				}
				else if(indexMap.containsKey(o2))
				{
					return 1;
				}
				else
				{
					return o1-o2;
				}
			}
		});
		
		for(int k=0;k<n;k++)
		{
			arr1[k]=arrWrapper[k];
		}
		
		System.out.println(Arrays.toString(arr1));
	}

	private static void sortByAnotherArray1(int[] arr1, int[] arr2) {
		
		int n=arr1.length;
		int m=arr2.length;
		
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<m;i++)
		{
			map.put(arr2[i],i);
		}
		
		Integer arrWrapper[]=new Integer[n];
		for(int j=0;j<n;j++)
		{
			arrWrapper[j]=arr1[j];
		}
		
		Arrays.sort(arrWrapper,(a,b)->{
			int indexA=map.getOrDefault(a,Integer.MAX_VALUE);
			int indexB=map.getOrDefault(b, Integer.MAX_VALUE);
			return Integer.compare(indexA, indexB);
		});
		
		for(int k=0;k<n;k++)
		{
			arr1[k]=arrWrapper[k];
		}
		
		System.out.println(Arrays.toString(arr1));
	}
}
