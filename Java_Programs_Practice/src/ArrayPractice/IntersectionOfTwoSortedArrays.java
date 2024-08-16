package ArrayPractice;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoSortedArrays {

	public static void main(String[] args) {
		
		int arr1[] = {1, 2, 3, 4} ,arr2 [] = {2, 4, 6, 7, 8};
		
		intersectionOfTwoSortedArraysBrute(arr1,arr2);
		intersectionOfTwoSortedArraysBetter(arr1, arr2);
		intersectionOfTwoSortedArraysOptimal(arr1, arr2);
		intersectionOfTwoSortedArrays(arr1,arr2);
	}

	private static void intersectionOfTwoSortedArrays(int[] arr1, int[] arr2) {
		
		int n=arr1.length,m=arr2.length;
		HashSet<Integer> hashSet=new HashSet<Integer>();
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++)
		{
			hashSet.add(arr1[i]);
		}
		
		for(int i=0;i<m;i++)
		{
			if(hashSet.contains(arr2[i]))
			{
				resultList.add(arr2[i]);
				hashSet.remove(arr2[i]);
			}
		}
		
		System.out.println(resultList);
	}

	private static void intersectionOfTwoSortedArraysOptimal(int[] arr1, int[] arr2) {
		
		int n=arr1.length,m=arr2.length,i=0,j=0;
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		while(i<n && j<m)
		{
			if(arr1[i]==arr2[j] && !resultList.contains(arr1[i]))
			{
				resultList.add(arr1[i]);
				i++;
				j++;
			}
			else if(arr1[i]<arr2[j])
			{
				i++;
			}
			else
			{
				j++;
			}
		}
		
		System.out.println(resultList);
		
	}

	private static void intersectionOfTwoSortedArraysBetter(int[] arr1, int[] arr2) {
		
		ArrayList<Integer> resultList=new ArrayList<Integer>();
		
		for(int num:arr1)
		{
			if(binarySearch(arr2,num) &&  !resultList.contains(num))
			{
				resultList.add(num);
			}
		}
		
		System.out.println(resultList);
	}

	private static boolean binarySearch(int[] arr, int num) {
		
		int left=0,right=arr.length-1;
		
		while(left<=right)
		{
			int mid=left+(right-left)/2;
			
			if(arr[mid]==num) return true;
			
			if(arr[mid]<num)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		return false;
	}

	private static void intersectionOfTwoSortedArraysBrute(int[] arr1, int[] arr2) {
		
		int n=arr1.length,m=arr2.length;
		
		ArrayList<Integer> resultList=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(arr1[i]==arr2[j] && !resultList.contains(arr1[i]))
				{
					resultList.add(arr1[i]);
					break;
				}
			}
		}
		
		System.out.println(resultList);
	}
}
