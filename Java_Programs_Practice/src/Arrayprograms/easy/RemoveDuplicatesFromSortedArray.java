package Arrayprograms.easy;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		
		int arr[] = {1,1,2,2,2,3,3};
		
//		int size=removeDuplicates1(arr);
//		
//		for(int i=0;i<size;i++)
//		{
//			System.out.println(arr[i]);
//		}
		
		int size=removeDuplicates2(arr);
		
		for(int i=0;i<size;i++)
		{
			System.out.println(arr[i]);
		}

	}

	private static int removeDuplicates2(int[] arr) {
		
		int i=0;
		int n=arr.length;
		
		for(int j=1;j<n;j++)
		{
			if(arr[i]!=arr[j])
			{
				i++;
				arr[i]=arr[j];
			}
		}
		return i+1;
	}

	private static int removeDuplicates1(int[] arr) {
		
		HashSet<Integer> set=new HashSet<Integer>();
		
		int n=arr.length;
		
		for(int i=0;i<n;i++)
		{
			set.add(arr[i]);
		}
		
		int size=set.size();
		
		int j=0;
		
		for(int s:set)
		{
			arr[j++]=s;
		}
		
		return size;
	}
}
