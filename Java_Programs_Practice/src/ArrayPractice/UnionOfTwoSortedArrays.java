package ArrayPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfTwoSortedArrays {

	public static void main(String[] args) {
		
		int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int arr2[] = {2, 3, 4, 4, 5, 11, 12};
		
		unionOfSortedArraysBrute(arr1,arr2,arr1.length,arr2.length);
		unionOfSortedArraysBetter(arr1, arr2,arr1.length,arr2.length);
		unionOfSortedArraysOptimal(arr1, arr2,arr1.length,arr2.length);

	}

	private static void unionOfSortedArraysOptimal(int[] arr1, int[] arr2, int m, int n) {
		
		int i=0,j=0;
		
		ArrayList<Integer> resultList=new ArrayList<>();
		
		while(i<m && j<n)
		{
			if(arr1[i]<=arr2[j])
			{
				if(resultList.size()==0 || resultList.get(resultList.size()-1)!=arr1[i])
					resultList.add(arr1[i]);
				i++;
			}
			else
			{
				if(resultList.size()==0 || resultList.get(resultList.size()-1)!=arr2[j])
					resultList.add(arr2[j]);
				j++;
			}
		}
		
		while(i<m)
		{
			if(resultList.get(resultList.size()-1)!=arr1[i])
				resultList.add(arr1[i]);
			i++;
		}
		
		while(j<n)
		{
			if(resultList.get(resultList.size()-1)!=arr2[j])
				resultList.add(arr2[j]);
			j++;
		}
		
		System.out.println(resultList);
		
	}

	private static void unionOfSortedArraysBetter(int[] arr1, int[] arr2, int m, int n) {
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int ele:arr1)
		{
			hashSet.add(ele);
		}
		
		for(int ele:arr2)
		{
			hashSet.add(ele);
		}
		
		for(int setEle:hashSet)
		{
			resultList.add(setEle);
		}
		
		System.out.println(resultList);
	}

	private static void unionOfSortedArraysBrute(int[] arr1, int[] arr2, int m, int n) {
		
		HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int i=0;i<m;i++)
		{
			hashMap.put(arr1[i],hashMap.getOrDefault(arr1[i],0)+1);
		}
		
		for(int i=0;i<n;i++)
		{
			hashMap.put(arr2[i],hashMap.getOrDefault(arr2[i],0)+1);
		}
		
		for(int mapEle:hashMap.keySet())
		{
			resultList.add(mapEle);
		}
		
		System.out.println(resultList);
	}
}
