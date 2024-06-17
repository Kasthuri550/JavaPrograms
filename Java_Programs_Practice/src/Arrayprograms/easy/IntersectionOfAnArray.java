package Arrayprograms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfAnArray {

	public static void main(String[] args) {
		
		int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};
        
//        findIntersectionBrute(array1,array2);
//        findIntersectionBetter(array1, array2);
        findIntersectionOptimal(array1, array2);
 
	}

	private static void findIntersectionOptimal(int[] array1, int[] array2) {
		
		HashSet<Integer> set=new HashSet<Integer>();
		ArrayList<Integer> intersectionList=new ArrayList<>();
		
		
		for(int i=0;i<array1.length;i++)
		{
			set.add(array1[i]);
		}
		
		for(int j=0;j<array2.length;j++)
		{
			if(set.contains(array2[j]))
			{
				intersectionList.add(array2[j]);
				set.remove(array2[j]);
			}
		}
		
		System.out.println(intersectionList);
	}

	private static void findIntersectionBetter(int[] array1, int[] array2) {
		
		ArrayList<Integer> intersectionList=new ArrayList<>();
		
		int i=0,j=0,m=array1.length,n=array2.length;
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		while(i<m && j<n)
		{
			if(array1[i]<array2[j])
			{
				i++;
			}
			else if(array1[i]>array2[j])
			{
				j++;
			}
			else
			{
				intersectionList.add(array1[i]);
				i++;
				j++;
			}
		}
		
		System.out.println(intersectionList);
	}

	private static void findIntersectionBrute(int[] array1, int[] array2) {
		
		ArrayList<Integer> intersectionList=new ArrayList<>();
		
		for(int i=0;i<array1.length;i++)
		{
			for(int j=0;j<array2.length;j++)
			{
				if(array1[i]==array2[j])
				{
					intersectionList.add(array1[i]);
					break;
				}
			}
		}
		
		System.out.println(intersectionList);
	}
}
