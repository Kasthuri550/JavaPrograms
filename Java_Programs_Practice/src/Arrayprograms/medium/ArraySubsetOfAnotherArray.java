package Arrayprograms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ArraySubsetOfAnotherArray {

	public static void main(String[] args) {
		
		int[] arr1 = { 11, 1, 13, 21, 3, 7 };
        int[] arr2 = { 11, 3, 7, 1 };
        
//        System.out.println(arraySubsetBrute(arr1,arr2));
//        System.out.println(arraySubsetBetter(arr1, arr2));
        System.out.println(arraySubsetOptimal(arr1, arr2));
	}

	private static boolean arraySubsetOptimal(int[] arr1, int[] arr2) {
		
		int m=arr1.length,n=arr2.length;
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		for(int i=0;i<m;i++)
		{
			al.add(arr1[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			if(!al.contains(arr2[i]))
			{
				return false;
			}
		}
		
		return true;
	}

	private static boolean arraySubsetBetter(int[] arr1, int[] arr2) {
		
		int m=arr1.length,n=arr2.length;
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<m;i++)
		{
			hashSet.add(arr1[i]);
		}
		
		for(int i=0;i<n;i++)
		{
			if(!hashSet.contains(arr2[i]))
			{
				return false;
			}
		}
		return true;
	}

	private static boolean arraySubsetBrute(int[] arr1, int[] arr2) {
		
		int m=arr1.length,n=arr2.length,i=0,j=0;
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		while(i<m && j<n)
		{
			if(arr1[i]<arr2[j])
			{
				i++;
			}
			else if(arr1[i]==arr2[j])
			{
				i++;
				j++;
			}
			else if(arr1[i]>arr2[j])
			{
				return false;
			}
		}
		
		return true;
		
	}
}
