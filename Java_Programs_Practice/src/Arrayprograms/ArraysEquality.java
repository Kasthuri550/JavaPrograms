package Arrayprograms;

import java.util.Arrays;
import java.util.HashSet;

public class ArraysEquality {

	public static void main(String[] args) {
		
		int arr1[] = {10, 51, 3, 43, 6};
        int arr2[] = {80, 71, 29, 3};
		
		disjoint1(arr1,arr2);
		disjoint2(arr1,arr2);
		disjoint3(arr1,arr2);
		disjoint4(arr1,arr2);
	}

	private static void disjoint4(int[] arr1, int[] arr2) {
		
		boolean status=true;
		
		if(arr1.length==arr2.length)
		{
			
			for(int i=0;i<arr1.length;i++)
			{
				if(arr1[i]!=arr2[i])
					status=false;
			}
			
		}
		else
		{
			status=false;
		}
		
		if(status)
		{
			System.out.println("Arrays are equal");
		}
		else
		{
			System.out.println("Arrays are not equal");
		}
		
	}

	private static void disjoint3(int[] arr1, int[] arr2) {
		
		boolean status=true;
		
		HashSet<Integer> hashSet=new HashSet<Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			hashSet.add(arr1[i]);
		}
		
		for(int j=0;j<arr2.length;j++)
		{
			if(hashSet.contains(arr2[j]))
			{
				status=false;
			}
		}
		
		if(status)
		{
			System.out.println("Arrays are equal");
		}
		else
		{
			System.out.println("Arrays are not equal");
		}
	}

	private static void disjoint2(int[] arr1, int[] arr2) {
		
		boolean status=true;
		
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
					status=false;
			}
		}
		
		if(status)
		{
			System.out.println("Arrays are equal");
		}
		else
		{
			System.out.println("Arrays are not equal");
		}
		
	}

	private static void disjoint1(int[] arr1, int[] arr2) {
		
		boolean status=Arrays.equals(arr1,arr2);
		
		if(status)
		{
			System.out.println("Arrays are equal");
		}
		else
		{
			System.out.println("Arrays are not equal");
		}
	}

}
